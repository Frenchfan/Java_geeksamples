package OOPSem4.Homework4;


import OOPSem4.Homework4.Model.Student;
import OOPSem4.Homework4.Model.Teacher;
import OOPSem4.Homework4.Service.UserService;
import OOPSem4.Homework4.impls.UserServiceImpl;


public class AddList {
    /**
     * Доделать проект(Использовать параметризацию)
     * Сохранение в файл, редактирование, чтение и удаление
     * Заготовка: https://github.com/besSmertniyKoder/untitled9
     * Дженерики и вайлдкардс: https://skillbox.ru/media/base/dzheneriki-v-java-dlya-samykh-malenkikh/
     * @param args
     */
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.add(new Student("Roman", 4.92f, 4, new Teacher("Антонина Петровна")));
        userService.add(new Student("Andrew", 4.52f, 1, new Teacher("Валентина Петровна")));
        userService.add(new Student("Nicolas", 3.2f, 1, new Teacher("Анастасия")));
        userService.add(new Student("Jeffrey", 5.00f, 2, new Teacher("Павел Иванович")));
        userService.add(new Student("Angela", 3.11f, 3, new Teacher("Петр Павел")));
        userService.add(new Student("Rose", 2.92f, 3, new Teacher("Антон")));
        userService.add(new Student("Jenny", 3.94f, 4, new Teacher("Крис")));
        userService.add(new Teacher("Bella"));


    }


}
