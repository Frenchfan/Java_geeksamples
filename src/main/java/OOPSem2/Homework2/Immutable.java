package OOPSem2.Homework2;

import java.util.HashMap;
import java.util.Map;

public final class Immutable {
    private final String name;

    private final int age;

    private final Map<String, String> myMap;

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
        return String.copyValueOf(name.toCharArray());
    }
    public int getAge() {
        int copyAge;
        return copyAge = age;
    }

    public Map<String, String> getMyMap() {
        Map<String, String> deepCopy = new HashMap<>();
        for(String key: myMap.keySet()) {
            deepCopy.put(key, myMap.get(key));
        }
        return deepCopy;
    }
}
