package OOPSem2;

public class Dog extends Animal{
    private  String name;
    private  int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    void tellAboutYourself() {
        System.out.printf("Привет, меня зовут %s, мой возраст %d \n", this.name, this.age);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
