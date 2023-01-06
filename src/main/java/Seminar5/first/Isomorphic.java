package Seminar5.first;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Isomorphic {
    /**
     * Даны 2 строки, написать метод, который вернет true, если эти строки являются изоморфными
     * и false, если нет. Строки изоморфны, если одну букву в первом слове можно заменить
     * на некоторую букву во втором слове, при этом
     * 1. повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением
     * порядка следования (Например, add - egg изоморфны)
     * 2. буква может не меняться, а остаться такой же (Например, note - code)
     * Пример 1:
     * Input: s = "foo", t = "bar"
     * Output: false
     * Пример 2:
     * Input: s = "paper", t = "title"
     * Output: true
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";

        if(isIsomorphic(s, t)) {
            System.out.println(s + " and " + t + " are isomorphic");
        } else System.out.println(s + " and " + t + " are NOT isomorphic");

        s = "paper";
        t = "title";

        if(isIsomorphic(s, t)) {
            System.out.println(s + " and " + t + " are isomorphic");
        } else System.out.println(s + " and " + t + " are NOT isomorphic");
    }


    public static boolean isIsomorphic(String s, String t) {
        if(s == null || t == null) {
            return false;
        }
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);

            if(map.containsKey(x)) {
                if(map.get(x) != y) {
                    return false;
                }
            } else {
                if(set.contains(y)) {
                    return false;
                }
                map.put(x, y);
                set.add(y);
            }
        }return true;
    }
}

