package OOPSem2;

//Реализовать метод tellAboutYourself() в наследниках
//Теперь кот рассказывает про породу
// Собака пусть про настроение
//*Перегрузить у собаки метод, что бы мы могли менять настроение
public abstract class Animal {
    abstract void tellAboutYourself();

    private String name;

    private int age;

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


}