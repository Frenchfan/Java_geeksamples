package Algorhythm.Seminar3;

public class test {
    /**
     * single line swap sample
     * @param args
     */
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        a = a ^ b ^ (b = a);
        System.out.println(a);
        System.out.println(b);
    }
}
