package Homework6;

import java.util.Objects;

public class Notebook {
    private int ram;
    private int ssdVolume;
    private String operatingSystem;
    private String color;
    private String brand;
    private int maxBatteryTime;

    public Notebook(int ram, int ssdVolume, String operatingSystem, String color, String brand, int maxBatteryTime) {
        this.ram = ram;
        this.ssdVolume = ssdVolume;
        this.operatingSystem = operatingSystem;
        this.color = color;
        this.brand = brand;
        this.maxBatteryTime = maxBatteryTime;
    }

    @Override
    public String toString() {
        return "Ноутбук " +
                brand +
                ", ram=" + ram + " Гб" +
                ", ssd=" + ssdVolume + " Гб" +
                ", ОС='" + operatingSystem + '\'' +
                ", цвет='" + color + '\'' +
                ", батарея= " + maxBatteryTime + " ч";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return ram == notebook.ram && ssdVolume == notebook.ssdVolume && maxBatteryTime == notebook.maxBatteryTime && Objects.equals(brand, notebook.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ram, ssdVolume, brand, maxBatteryTime);
    }

    public int getRam() {
        return ram;
    }

    public int getSsdVolume() {
        return ssdVolume;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public int getMaxBatteryTime() {
        return maxBatteryTime;
    }
}
