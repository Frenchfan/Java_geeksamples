package Homework5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    //Set - чтобы избежать повторов номеров для одного и того же человека
    // Конечно, при условии строгого соблюдения формата номера
    private static Map<String, Set<String>> phoneNumbers = new HashMap<>();

    public void add(String name, Set<String> number) {
        if (phoneNumbers.containsKey(name)) phoneNumbers.get(name).addAll(number);
        else {
            phoneNumbers.put(name, number);
        }
    }

    public Set<String> find(String name) {
        if (phoneNumbers.containsKey(name)) return phoneNumbers.get(name);
        return new HashSet<>();
    }

    public boolean delete(String name, String number) {
        if (phoneNumbers.containsKey(name)) {
            if (phoneNumbers.get(name).contains(number)) {
                phoneNumbers.get(name).remove(number);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String name: phoneNumbers.keySet()) {
            stringBuilder.append("Абонент ").append(name).append(", записаны следующие номера: ").append("\n");
            stringBuilder.append(phoneNumbers.get(name)).append("\n");
        }
        return stringBuilder.toString();
    }
}
