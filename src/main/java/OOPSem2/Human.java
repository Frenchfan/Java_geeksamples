package OOPSem2;

import java.util.List;
import java.util.*;


// Описать человека с возможностью заведения животных
// Добавить методы по изменению параметров
// Сделать добавление животных интерактивным
// Вывести в консолоь

public class Human extends Animal {
    private List<Animal> pets;

    public List<Animal> getPets() {
        return pets;
    }

    public Human(List<Animal> pets, String name) {

        pets.removeIf(next -> next instanceof Human);
        this.pets = pets;
        this.setName(name);
    }

    public Human(String name) {
        this.setName(name);
    }



    @Override
    void tellAboutYourself() {
        System.out.println("Я - человек");
    }
}
