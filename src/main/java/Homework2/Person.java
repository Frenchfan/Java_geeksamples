package Homework2;

public class Person {
    public String name;
    public String country;
    public String city;
    public Byte age;
    //для возраста используем обертку, раз уж возможен null
    // - при корректной сериализации в json этого можно было бы избежать
}
