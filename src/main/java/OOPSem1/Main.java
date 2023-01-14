package OOPSem1;

public class Main {

    public static void main(String[] args) {
        System.out.println("Вариант реализации генеалогического древа: ");
        System.out.println("Реализация на базе HashSet коллекции экземлпяров класса Person с полями-ссылками " +
                "на других членов семьи. Семейные связи устанавливаются произвольно через методы класса. " +
                "Null-safety обеспечивается применением класса Optional");
        System.out.println("Ниже - распечатка по 9 экземплярам коллекции, " +
                "коллекция - статическая, доступна через имя класса");
        task1();
        System.out.println("Задача 2: Человек-ТВ - взаимодействие:");

        task2();

        System.out.println("Задача 3: тигр нападает на человек");

        task3();
    }

    private static void task3() {
        Human human = new Human("Вася");
        Animal tiger = new Tiger();
        for (int i = 0; i < 22; i++) {
            tiger.attack(human);
        }
    }

    private static void task2() {
        TV tv = new TV();
        Human human = new Human("Иннокентий");
        for (int i = 0; i < 24; i++) {
            human.turnOnOffTV(tv);
        }
        human.gotoSleep();
        human.turnOnOffTV(tv);
    }

    private static void task1() {
        Person p1 = new Person("Вася", true);
        Person p2 = new Person("Маша", false);
        Person p3 = new Person("Коля", true);
        Person p9 = new Person("Алевтина", false);
        Person p4 = new Person("Василиса Петровна", false);
        Person p5 = new Person("Николай Иванович", true);
        Person p6 = new Person("Ольга Бузова", false);
        Person p7 = new Person("Тимур Батрутдинов", true);
        Person p8 = new Person("Филипп Киркоров", true);

        p1.setFather(p5);
        p1.setMother(p4);
        p1.setChild(p3);
        p2.setMother(p6);
        p2.setFather(p7);
        p2.setChild(p3);
        p5.setFather(p8);
        p9.setSisterOrBrother(p3);
        p9.setMother(p2);
        p9.setFather(p1);

        Person.family.forEach(System.out::println);
    }


}
