package OOPSem1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static List<Human> myList = new LinkedList<>();

    public static void main(String[] args) {
        Human Adam = new Human("Адам", "м", true);
        Human Eva = new Human("Ева", "м", true);
        Human Isaac = new Human("Исаак", "м", true);


        myList.add(Adam);
        myList.add(Eva);
        myList.add(Isaac);
        List<Human> myChilren = checkChildren(Adam);
        List<Human> myParents = checkParents(Isaac);


    }

    public static List<Human> checkChildren(Human human) {
        int index = myList.indexOf(human);
        if (index < myList.size() - 1) {
            List<Human> children = new ArrayList<>(myList.subList(index +1 , myList.size()));
            System.out.println("У человека " + human);
            System.out.println("Следующие потомки: ");
            for (Human myhuman: children) {
                System.out.println(myhuman);
            }
        }
        return new ArrayList<>();
    }

    public static List<Human> checkParents(Human human) {
        int index = myList.indexOf(human);
        if (index > 0) {
            List<Human> parents = new ArrayList<>(myList.subList(0 , index));
            System.out.println("У человека " + human);
            System.out.println("Следующие предки: ");
            for (Human myhuman: parents) {
                System.out.println(myhuman);
            }
        }
        return new ArrayList<>();
    }
}
