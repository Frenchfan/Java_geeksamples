package Portfolio.Springeventsourcing.db;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.GetResponse;
import Portfolio.Springeventsourcing.Person;
import Portfolio.Springeventsourcing.api.PersonApiImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class DataProcessor {

    /**
     * Have to use one queue to follow the FIFO order,
     * use the routing key to distinguish between
     * the operations
     */
    private final String queueName = "implement";

    private final DataSource dataSource;
    private final ConnectionFactory connectionFactory;

    private static final Logger logger = LoggerFactory.getLogger(
            PersonApiImpl.class);

    public DataProcessor(DataSource dataSource, ConnectionFactory connectionFactory) {
        this.dataSource = dataSource;
        this.connectionFactory = connectionFactory;
    }

    @PostConstruct
    public void endlessCycle() {
        try (com.rabbitmq.client.Connection connection = this.connectionFactory.newConnection();
             Channel channel = connection.createChannel()) {
            while (!Thread.currentThread().isInterrupted()) {
                GetResponse message = channel.basicGet(queueName, true);
                if (message != null) {
                    String received = new String(message.getBody());
                    String routingKey = message.getEnvelope().getRoutingKey();
                    if ("delete".equals(routingKey)) {
                        Long id = Long.parseLong(received);
                        deletePerson(id);
                    } else if ("insert".equals(routingKey)) {
                        insertPerson(received);
                    } else {
                        System.out.println("These functions have not been developed yet");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void insertPerson(String received) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Person person = mapper.readValue(received, Person.class);
            if (findPerson(person.getId())) {
                String query = "UPDATE person SET first_name = ?, last_name = ?, middle_name = ? WHERE person_id = ?;";
                try (Connection con = dataSource.getConnection();
                     PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setString(1, person.getName());
                    pst.setString(2, person.getLastName());
                    pst.setString(3, person.getMiddleName());
                    pst.setLong(4, person.getId());
                    pst.executeUpdate();
                    System.out.println("Updated info for the user with id = " + person.getId());
                } catch (SQLException exception) {
                    System.err.println(exception.getMessage());
                }
            } else {
                String query = "INSERT INTO person VALUES (?, ?, ?, ?);";
                try (Connection con = dataSource.getConnection();
                     PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setLong(1, person.getId());
                    pst.setString(2, person.getName());
                    pst.setString(3, person.getLastName());
                    pst.setString(4, person.getMiddleName());
                    pst.executeUpdate();
                    System.out.println("Inserted new user with id = " + person.getId());
                } catch (SQLException exception) {
                    System.err.println(exception.getMessage());
                }
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void deletePerson(Long id) {
        if (findPerson(id)) {
            String query = "DELETE FROM person WHERE person_id = ?;";
            try (Connection con = dataSource.getConnection();
                 PreparedStatement pst = con.prepareStatement(query)) {
                pst.setLong(1, id);
                pst.executeQuery();
            } catch (SQLException exception) {
                System.err.println(exception.getMessage());
            }
        } else {
            logger.error("Failed to delete person - no data found for the the person with ID {}.", id);
        }
    }

    public boolean findPerson(Long personId) {
        String query = "SELECT * FROM person WHERE person_id = ?;";
        boolean result = false;
        try (Connection con = dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setLong(1, personId);
            ResultSet personSet = pst.executeQuery();
            if (personSet.next()) {
                result = true;
            }
        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }
        return result;
    }
}
