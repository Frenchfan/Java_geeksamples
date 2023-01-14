package OOPSem1;

public class Tiger extends Animal{
    @Override
    public void attack(Human human) {
        if (human.getStrength() > 5) {
            human.setStrength(human.getStrength() - 5);
            System.out.println("Тигр атакует человека по имени " + human.getName());
            System.out.println("У человека по имени " + human.getName() + " осталось " +
                    human.getStrength() + " единиц энергии");
        }
        else System.out.println("Человек по имени " + human.getName() + " погибает или уже погиб");
    }
}
