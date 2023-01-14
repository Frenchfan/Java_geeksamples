package OOPSem1;

public class Human {

    private String name;
    private String sex;
    private boolean liveStatus;


    public Human(String name, String sex, boolean liveStatus) {
        this.name = name;
        this.sex = sex;
        this.liveStatus = liveStatus;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", liveStatus=" + liveStatus +
                '}';
    }
}
