package Homework6;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static Set<Notebook> myNotebookSet = new HashSet<>(Set.of(
            new Notebook(8, 512, "Windows", "Red", "Samsung", 14),
            new Notebook(16, 1024, "NoOS", "Blue", "Dell", 3),
            new Notebook(8, 512, "Linux", "Black", "HP", 15),
            new Notebook(32, 2048, "MacOS", "Yellow", "Samsung", 5),
            new Notebook(8, 512, "Windows", "Green", "HP", 7),
            new Notebook(8, 512, "Windows", "Grey", "Asus", 6),
            new Notebook(16, 512, "Linux", "Silver", "Acer", 4),
            new Notebook(8, 512, "NoOS", "Pink", "EliteBook", 5),
            new Notebook(8, 512, "Windows", "Orange", "Samsung", 8),
            new Notebook(8, 512, "Fedora", "White", "Dell", 17)
    ));

    public static void main(String[] args) {
        filter(askcriterion());

    }

    private static void filter(int askcriterion) {
        Scanner scanner = new Scanner(System.in);
        switch (askcriterion) {
            case 1 -> {
                int ramChoice;
                Set<Integer> myRAM = myNotebookSet.stream()
                        .map(Notebook::getRam)
                        .collect(Collectors.toCollection(TreeSet::new));
                do {
                    System.out.println("Введите объем оперативной памяти. Доступны только следующие варианты: ");
                    System.out.println(myRAM);
                    ramChoice = scanner.nextInt();
                } while (!myRAM.contains(ramChoice));
                System.out.println("А вот и Ваша подборка ноутбуков: ");
                int finalRamChoice = ramChoice;
                myNotebookSet.stream()
                        .filter(x -> x.getRam() == finalRamChoice)
                        .collect(Collectors.toSet()).forEach(System.out::println);
            }
            case 2 -> {
                int ssdChoice;
                Set<Integer> mySSD = myNotebookSet.stream()
                        .map(Notebook::getSsdVolume)
                        .collect(Collectors.toCollection(TreeSet::new));
                do {
                    System.out.println("Введите объем SSD. Доступны только следующие варианты: ");
                    System.out.println(mySSD);
                    ssdChoice = scanner.nextInt();
                } while (!mySSD.contains(ssdChoice));
                System.out.println("А вот и Ваша подборка ноутбуков: ");
                int finalSSDChoice = ssdChoice;
                myNotebookSet.stream()
                        .filter(x -> x.getSsdVolume() == finalSSDChoice)
                        .collect(Collectors.toSet()).forEach(System.out::println);
            }
            case 3 -> {
                String osChoice;
                Set<String> myOS = myNotebookSet.stream()
                        .map(Notebook::getOperatingSystem)
                        .collect(Collectors.toCollection(TreeSet::new));
                do {
                    System.out.println("Введите операционную систему. Доступны только следующие варианты: ");
                    System.out.println(myOS);
                    osChoice = scanner.nextLine();
                } while (!myOS.contains(osChoice));
                System.out.println("А вот и Ваша подборка ноутбуков: ");
                String finalOSChoice = osChoice;
                myNotebookSet.stream()
                        .filter(x -> x.getOperatingSystem().equals(finalOSChoice))
                        .collect(Collectors.toSet()).forEach(System.out::println);
            }
            case 4 -> {
                String colorChoice;
                Set<String> myColor = myNotebookSet.stream()
                        .map(Notebook::getColor)
                        .collect(Collectors.toCollection(TreeSet::new));
                do {
                    System.out.println("Введите цвет. Доступны только следующие варианты: ");
                    System.out.println(myColor);
                    colorChoice = scanner.nextLine();
                } while (!myColor.contains(colorChoice));
                System.out.println("А вот и Ваша подборка ноутбуков: ");
                String finalColorChoice = colorChoice;
                myNotebookSet.stream()
                        .filter(x -> x.getColor().equals(finalColorChoice))
                        .collect(Collectors.toSet()).forEach(System.out::println);
            }
            case 5 -> {
                String brandChoice;
                Set<String> myBrand = myNotebookSet.stream()
                        .map(Notebook::getBrand)
                        .collect(Collectors.toCollection(TreeSet::new));
                do {
                    System.out.println("Введите бренд. Доступны только следующие варианты: ");
                    System.out.println(myBrand);
                    brandChoice = scanner.nextLine();
                } while (!myBrand.contains(brandChoice));
                System.out.println("А вот и Ваша подборка ноутбуков: ");
                String finalBrandChoice = brandChoice;
                myNotebookSet.stream()
                        .filter(x -> x.getBrand().equals(finalBrandChoice))
                        .collect(Collectors.toSet()).forEach(System.out::println);
            }
            case 6 -> {
                int batteryChoice;
                Set<Integer> myBattery = myNotebookSet.stream()
                        .map(Notebook::getMaxBatteryTime)
                        .collect(Collectors.toCollection(TreeSet::new));
                do {
                    System.out.println("Введите время работы от аккумулятора. Доступны только следующие варианты: ");
                    System.out.println(myBattery);
                    batteryChoice = scanner.nextInt();
                } while (!myBattery.contains(batteryChoice));
                System.out.println("А вот и Ваша подборка ноутбуков: ");
                int finalBatteryChoice = batteryChoice;
                myNotebookSet.stream()
                        .filter(x -> x.getMaxBatteryTime() == finalBatteryChoice)
                        .collect(Collectors.toSet()).forEach(System.out::println);
            }
        }
    }

    private static int askcriterion() {
        System.out.println("Введите цифру, соответствующую необходимому критерию: ");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем SSD");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.println("5 - Бренд");
        System.out.println("6 - Автономность в часах");
        return new Scanner(System.in).nextInt();
    }

    /**
     * 1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
     * 2. Создать множество ноутбуков.
     * 3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
     * отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
     * “Введите цифру, соответствующую необходимому критерию:
     * 1 - ОЗУ
     * 2 - Объем ЖД
     * 3 - Операционная система
     * 4 - Цвет …
     * 1. Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
     * 2. Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
     */
}
