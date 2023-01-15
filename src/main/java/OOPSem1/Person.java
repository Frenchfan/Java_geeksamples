package OOPSem1;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Person {
    public static Set<Person> family = new HashSet<>();
    private String name;

    private boolean sex;

    private Person mother;

    private Person father;

    private Person child;

    private Person sisterOrBrother;

    public Person(String name, boolean sex) {
        this.name = name;
        this.sex = sex; // false - девочка
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

    public void setSisterOrBrother(Person person) {
        this.sisterOrBrother = person;
        person.sisterOrBrother = this;
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
        String optSisterOrBrother = Optional.ofNullable(sisterOrBrother)
                .map(Person::getName)
                .orElse("сестра или брат не известны");
        return "У человека " +
                "с именем " + name + '\'' +
                ", маму зовут: " + optMother +
                ", папу зовут: " + optFather +
                ", сестру или брата зовут: " + optSisterOrBrother +
               ", ребенка зовут: " + optChild;
    }
}
