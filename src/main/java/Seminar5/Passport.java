package Seminar5;

import java.util.ArrayList;
import java.util.HashMap;

public class Passport {
    private static HashMap<String, ArrayList<Integer>> passportNumber = new HashMap<>();

    public void add(String name, Integer number) {
        if(passportNumber.containsKey(name)) {
            passportNumber.get(name).add(number);
        } else {
            ArrayList<Integer> values = new ArrayList<>();
            values.add(number);
            passportNumber.put(name, values);
        }
    }

    public ArrayList<Integer> find(String name) {
        if(passportNumber.containsKey(name)) {
            return passportNumber.get(name);
        }
        return new ArrayList<>();
    }

    public static HashMap<String, ArrayList<Integer>> getPassportNumber() {
        return passportNumber;
    }
}
