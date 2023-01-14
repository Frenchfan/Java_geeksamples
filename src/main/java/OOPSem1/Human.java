package OOPSem1;

public class Human {


    private int strength;

    private String name;

    public void turnOnOffTV(TV tv) {
        if (this.strength > 5 && !tv.isOn()) {
            System.out.println("На включение ТВ потрачено 5 единиц энергии");
            strength -= 5;
            System.out.println("У " + this.name + " осталось " + this.strength + " единиц энергии");
            tv.setOn(true);
            System.out.println("Телевизор включен");
        } else if (this.strength > 5 && tv.isOn()) {
            System.out.println("На выключение ТВ потрачено 5 единиц энергии");
            strength -= 5;
            System.out.println("У " + this.name + " осталось " + this.strength + " единиц энергии");
            tv.setOn(false);
            System.out.println("Телевизор выключен");
        }else System.out.println("Ничего не выйдет, сил не осталось - пора спать!");
    }

    public void gotoSleep() {
        System.out.println(this.name + " лег спать" );
        System.out.println("Силы восстановлены");
        strength = 100;
    }

    public Human(String name) {
        this.name = name;
        this.strength = 100;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
