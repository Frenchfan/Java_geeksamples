package OOPSem2.Homework2;

import java.util.HashMap;
import java.util.Map;

public final class Immutable {
    private String name;

    private int age;

    Map<String, String> myMap;

    public Immutable(String name, int age, Map<String, String> myMap) {
        this.name = name;
        this.age = age;
        Map<String, String> deepCopy = new HashMap<>();
        for(String key: myMap.keySet()) {
            deepCopy.put(key, myMap.get(key));
        }
        this.myMap = myMap;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public Map<String, String> getMyMap() {
        return myMap;
    }
}
