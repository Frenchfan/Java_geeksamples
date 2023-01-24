package OOPSem4;


public class Main {
    public static void main(String[] args) {
        Student Kolya = new Student();
        Kolya.setYear(2005);
        Student Masha = new Student();
        Masha.setYear(2007);
        StudentComparator comparator = new StudentComparator();
        System.out.println(comparator.compare(Kolya, Masha));
        System.out.println(Kolya.compareTo(Masha));

    }
}
