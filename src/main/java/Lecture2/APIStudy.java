package Lecture2;

public class APIStudy {
    /**
     * demonstrated the speed of Stringbuilder use
     * @param symbol - a symbol to build a line out of 1 mln symbols
     * @return String with 1 mln symbols
     */
    public static String myString(String symbol) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1_000_000; i++) {
            sb.append(symbol);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(myString("+"));
    }
}
