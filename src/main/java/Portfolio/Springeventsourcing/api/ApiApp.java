package Portfolio.Springeventsourcing.api;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApiApp {
  public static void main(String[] args) throws Exception {
    // Тут пишем создание PersonApi, запуск и демонстрацию работы
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
    applicationContext.start();

    // пишем взаимодействие с PersonApi - это можно использовать для тестирования

    PersonApi personApi = applicationContext.getBean(PersonApiImpl.class);

    personApi.savePerson(12L, "Иван", "Макаров", "Петрович");
    personApi.savePerson(2L, "Коля", "Безухов", "Христофорович");
    personApi.savePerson(8L, "Анна", "Макарова", "Петровна");
    personApi.savePerson(9L, "Иван", "Жуков", "Алексеевич");
    personApi.savePerson(8L, "Сергей", "Фролов", "Юрьевич");
    personApi.deletePerson(1L);
    System.out.println(personApi.findPerson(2L));
    System.out.println(personApi.findAll());
  }
}
