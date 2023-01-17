package OOPSem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Шарик", 4);
//        Cat cat = new Cat("Матроскин", 6);
//
//        dog.tellAboutYourself();
//        cat.tellAboutYourself();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя человека:");
        String name = scanner.nextLine();
        System.out.println("Сколько питомцев у человека?");
        int quantity = scanner.nextInt();
        List<Animal> pets = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            System.out.println("Собака (1) или кошка (0)?");
            int type = scanner.nextInt();
            if (type == 1) {
                pets.add(new Dog("Собака", i));
            } else {
                pets.add(new Cat("Мурзик", i));
            }
        }
        Animal human2 = new Human(null, "Коля");
        if (human2 instanceof Cat) {
            pets.add(human2);
        }


        Human human = new Human(pets, name);
        System.out.println(human.getName());
        human.getPets().forEach(System.out::println);



    }
}
