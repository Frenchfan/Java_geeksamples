package OOPSem2.Homework2;

import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        Immutable myImmutable = new Immutable("Коля",  22,
                Map.of("Ключ", "Значение"));

        Map<String, String> map = new HashMap<>();
        map.put("good key", "value");

        // Мы не можем изменять состояние объекта
        // через добавление элементов в полученную map
        System.out.println("Result after modifying the map after we get it from the object");
        myImmutable.getMyMap().put("bad key", "another value");
        myImmutable.getMyMap().keySet().forEach(System.out::println);

        System.out.println("Result of the object's map after modifying the initial map");
        map.put("bad key", "another value");
        myImmutable.getMyMap().keySet().forEach(System.out::println);

    }
}
