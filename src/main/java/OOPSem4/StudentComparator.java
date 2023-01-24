package OOPSem4;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getYear() > o2.getYear()) return 1;
        else if (o1.getYear() == o2.getYear()) return 0;
        return -1;
    }
}
