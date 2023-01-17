package OOPSem2;

public class Dog extends Animal{

    public Dog(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }


    @Override
    void tellAboutYourself() {
        System.out.printf("Привет, меня зовут %s, мой возраст %d \n", this.getName(), this.getAge());
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + this.getName() + '\'' +
                ", age=" + this.getAge() +
                '}';
    }
}
