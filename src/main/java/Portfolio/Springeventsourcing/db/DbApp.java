package Portfolio.Springeventsourcing.db;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class DbApp {
  public static void main(String[] args) throws Exception {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
    applicationContext.start();
  }
}
