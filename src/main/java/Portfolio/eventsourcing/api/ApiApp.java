package Portfolio.eventsourcing.api;

import com.rabbitmq.client.ConnectionFactory;
import Portfolio.DbUtil;
import Portfolio.RabbitMQUtil;

import javax.sql.DataSource;
import java.sql.SQLException;

public class ApiApp {
  public static void main(String[] args) throws Exception {
    DataSource dataSource = initDb();
    ConnectionFactory connectionFactory = initMQ();
    PersonApiImpl personApi = new PersonApiImpl(dataSource, connectionFactory);
    personApi.savePerson(12L, "Иван", "Макаров", "Петрович");
    personApi.savePerson(2L, "Коля", "Безухов", "Христофорович");
    personApi.savePerson(8L, "Анна", "Макарова", "Петровна");
    personApi.savePerson(9L, "Иван", "Жуков", "Алексеевич");
    personApi.savePerson(8L, "Сергей", "Фролов", "Юрьевич");
    personApi.deletePerson(1L);
    System.out.println(personApi.findPerson(2L));
    System.out.println(personApi.findAll());
  }

  private static ConnectionFactory initMQ() throws Exception {
    return RabbitMQUtil.buildConnectionFactory();
  }

  private static DataSource initDb() throws SQLException {
    DataSource dataSource = DbUtil.buildDataSource();
    return dataSource;
  }
}
