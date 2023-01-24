package OOPSem4;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name;
    private float grade;
    private int year;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Float.compare(student.grade, grade) == 0 && year == student.year && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grade, year);
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.getYear(), o.getYear());
    }
}
