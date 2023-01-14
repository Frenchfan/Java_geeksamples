package OOPSem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Person {
    public static List<Person> family = new ArrayList<>();
    private String name;

    private boolean sex;

    private Person mother;

    private Person father;

    private Person child;

    public Person(String name, boolean sex) {
        this.name = name;
        this.sex = sex; // 0 - девочка
        mother = null;
        father = null;
        child = null;
        family.add(this);
    }

    public void setMother(Person person) {
        this.mother = person;
        person.child = this;
    }

    public void setFather(Person person) {
        this.father = person;
        person.child = this;
    }

    public void setChild(Person person) {
        this.child = person;
        if (sex) person.father = this;
        else person.mother = this;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String optMother = Optional.ofNullable(mother)
                .map(Person::getName)
                .orElse("мама не известна");
        String optFather = Optional.ofNullable(father)
                .map(Person::getName)
                .orElse("папа не известен");
        String optChild = Optional.ofNullable(child)
                .map(Person::getName)
                .orElse("детей пока нет");
        return "У человека " +
                "с именем " + name + '\'' +
                ", маму зовут: " + optMother +
                ", папу зовут: " + optFather +
               ", ребенка зовут: " + optChild;
    }
}
