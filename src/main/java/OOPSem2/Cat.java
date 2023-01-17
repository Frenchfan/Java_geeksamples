package OOPSem2;

public class Cat extends Animal {
    public Cat(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }


    @Override
    void tellAboutYourself() {
        System.out.printf("Привет, меня зовут %s, мой возраст %d\n", this.getName(), this.getAge());
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + this.getName() + '\'' +
                ", age=" + this.getAge() +
                '}';
    }
}