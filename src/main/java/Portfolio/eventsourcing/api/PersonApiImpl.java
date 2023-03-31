package Portfolio.eventsourcing.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import Portfolio.eventsourcing.Person;

import javax.sql.DataSource;
import java.io.StringWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonApiImpl implements PersonApi {

    private final DataSource dataSource;
    private final ConnectionFactory connectionFactory;

    String exchangeName = "exc";
    String queueName = "implement";

    public PersonApiImpl(DataSource dataSource, ConnectionFactory connectionFactory) {
        this.dataSource = dataSource;
        this.connectionFactory = connectionFactory;
    }

    @Override
    public void deletePerson(Long personId) {
        try (com.rabbitmq.client.Connection connection = connectionFactory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC);
            channel.queueDeclare(queueName, true, false, false, null);
            channel.queueBind(queueName, exchangeName, "delete");
            channel.basicPublish(exchangeName, "delete", null, String.valueOf(personId).getBytes());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void savePerson(Long personId, String firstName, String lastName, String middleName) {
        ObjectMapper mapper = new ObjectMapper();
        Person person = new Person(personId, firstName, lastName, middleName);
        String routingKey = "insert";
        sendObjToQueue(mapper, exchangeName, person, queueName, routingKey);
}

    private void sendObjToQueue(ObjectMapper mapper, String exchangeName, Person person, String queueName, String routingKey) {
        try (com.rabbitmq.client.Connection connection = connectionFactory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC);
            channel.queueDeclare(queueName, true, false, false, null);
            channel.queueBind(queueName, exchangeName, routingKey);
            StringWriter stringWriter = new StringWriter();
            mapper.writeValue(stringWriter, person);
            channel.basicPublish(exchangeName, routingKey, null, stringWriter.toString().getBytes());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Person findPerson(Long personId) {
        String query = "SELECT * FROM person WHERE person_id = ?;";
        Person person = new Person();
        try (Connection con = dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setLong(1, personId);
            ResultSet personSet = pst.executeQuery();
            if (personSet.next()) {
                parsePerson(person, personSet);
            } else {
                person = null;
            }
        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }
        return person;
    }

    private static void parsePerson(Person person, ResultSet personSet) throws SQLException {
        person.setId(personSet.getLong(1));
        person.setName(personSet.getString(2));
        person.setLastName(personSet.getString(3));
        person.setMiddleName(personSet.getString(4));
    }

    @Override
    public List<Person> findAll() {
        String query = "SELECT * FROM person;";
        List<Person> people = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement()) {
            ResultSet personSet = st.executeQuery(query);
            while (personSet.next()) {
                Person person = new Person();
                parsePerson(person, personSet);
                people.add(person);
            }
        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }
        return people;
    }
}
