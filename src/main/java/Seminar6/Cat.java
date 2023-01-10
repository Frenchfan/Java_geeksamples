package Seminar6;

import java.util.Objects;

public class Cat {
    /**
     * Имя кошки
     */
    private String name;
    /**
     * цвет кошки
     */
    private String color;
    /**
     * возраст кошки
     */
    private int age;
    /**
     * номер паспорта вакцинации кошки
     */
    private int passportVaccinationsNumber;

    public Cat(String name, int age, String color, int passportVaccinationsNumber) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.passportVaccinationsNumber = passportVaccinationsNumber;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public int getPassportVaccinationsNumber() {
        return passportVaccinationsNumber;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", passportVaccinationsNumber=" + passportVaccinationsNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && passportVaccinationsNumber == cat.passportVaccinationsNumber && Objects.equals(name, cat.name) && Objects.equals(color, cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color);
    }
}
