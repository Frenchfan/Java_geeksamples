package OOPSem4;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o1.getGrade(), o2.getGrade());
    }
}
