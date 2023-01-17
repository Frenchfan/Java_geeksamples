package OOPSem2;

import java.util.List;

// Описать человека с возможностью заведения животных
// Добавить методы по изменению параметров
// Сделать добавление животных интерактивным
// Вывести в консолоь

public class Human extends Animal {
    private List<Animal> pets;

    private String name;

    public String getName() {
        return name;
    }

    public List<Animal> getPets() {
        return pets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human(List<Animal> pets, String name) {
        this.pets = pets;
        this.name = name;
    }

    @Override
    void tellAboutYourself() {
        System.out.println("Я - человек");
    }
}
