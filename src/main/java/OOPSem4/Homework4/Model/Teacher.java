package OOPSem4.Homework4.Model;

import java.util.List;
import java.util.Objects;

public class Teacher extends User {

    public Teacher(String name) {
        this.setName(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(this.getName(), teacher.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName());
    }

    @Override
    public String toString() {
        return "_Teacher_"
                + this.getName() +
                "\n";
    }
}
