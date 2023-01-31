package OOPSem4.Homework4;

import OOPSem4.Homework4.Model.Student;
import OOPSem4.Homework4.Model.Teacher;
import OOPSem4.Homework4.Model.User;
import OOPSem4.Homework4.Service.UserService;
import OOPSem4.Homework4.View.UserView;
import OOPSem4.Homework4.impls.UserServiceImpl;

import java.awt.*;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import javax.swing.*;

public class Main extends JFrame {
    private static int generatingCounter = 0;
    private static JLabel editHint = new JLabel("Edit Name, Grade, Year and Teacher");
    private static JPanel buttons;
    private static UserService userService = new UserServiceImpl();
    private static List<User> userList = userService.getAllUsers();


    public static void createGUI() {
        UserView userView = new UserView(userList);
        JFrame frame = new JFrame("List of Teachers and Students - combined");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTable table = mainTable(userView);

        JPanel buttons = buttonsLabel(userService, userList, table);
        JPanel myText = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JScrollPane scrollPane = new JScrollPane(table);

        frame.getContentPane().add(scrollPane);
        frame.getContentPane().add(buttons, "South");

        frame.setPreferredSize(new Dimension(1450, 800));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JPanel buttonsLabel(UserService userService, List<User> userList, JTable table) {
        buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton addStudent = new JButton("Add Student");
        addStudent.addActionListener(e -> {
            userService.add(new Student("Generated" + generatingCounter++, 2.52f,
                    3, new Teacher("Павел Иванович")));
            table.updateUI();
        });
        JButton addTeacher = new JButton("Add Teacher");
        addTeacher.addActionListener(e -> {
            userService.add(new Teacher("Generated" + generatingCounter++));
            table.updateUI();
        });
        //Создание кнопки удаления строки таблицы
        JButton removeTile = new JButton("Delete");
        removeTile.addActionListener(e -> {
            // Номер выделенной строки
            int idx = table.getSelectedRow();
            // Удаление выделенной строки
            userService.remove(idx);
            table.updateUI();
        });
        JButton saveAll = new JButton("Save Changes");
        saveAll.addActionListener(e -> {
            userService.saveAll(userList);
        });

        JPanel panelCheck = filterCheckers(userService, table);

        buttons.add(editHint);

        buttons.add(addStudent);
        buttons.add(addTeacher);
        buttons.add(removeTile);
        buttons.add(saveAll);
        buttons.add(panelCheck);
        return buttons;
    }

    /**
     * Filtering options checkers and listeners
     *
     * @param userService
     * @param table
     * @return
     */
    private static JPanel filterCheckers(UserService userService, JTable table) {
        JPanel panelCheck = new JPanel();
        panelCheck.setBorder(BorderFactory.createTitledBorder("Show only:"));
        String[] namesOptions = {"Total list", "Students only ", "Students with" +
                " grade > 75% of the max grade (5)",
                "< 50%", "<25%", "Teachers only"};
        ButtonGroup bg2 = new ButtonGroup();
        JCheckBox[] check = new JCheckBox[6];
        for (int i = 0; i < namesOptions.length; i++) {
            check[i] = new JCheckBox(namesOptions[i]);
            panelCheck.add(check[i]);
            bg2.add(check[i]);
        }
        //No filtering
        check[0].addActionListener(e -> {
            editHint.setText("Edit Name, Grade, Year and Teacher");
            table.setEnabled(true);
            userService.getRepository().load();
            for (int i = 1; i < 5; i++) {
                buttons.getComponent(i).setEnabled(true);
            }
            table.updateUI();
        });
        //Filtering students only
        check[1].addActionListener(e -> {
            noEdit(userService, table);
            List<User> students = userService.getStudents();
            userService.getRepository().setUsers(students);
            table.updateUI();
        });
        //Filtering students with >75% max grade
        check[2].addActionListener(e -> {
            noEdit(userService, table);
            userService.getRepository().load();
//            OptionalDouble averageValue = userService.getStudents().stream()
//                    .map(x-> (Student) x)
//                    .map(Student::getGrade)
//                    .map(Double.class::cast)
//                    .mapToDouble(Double::doubleValue)
//                    .average();
            List<User> bestStudents = userService.getStudents().stream()
                    .map(x -> (Student) x)
                    .filter(x-> x.getGrade() > 0.75 * 5)
                    .collect(Collectors.toList());
            userService.getRepository().setUsers(bestStudents);
            table.updateUI();
        });
        //Filtering students with <50% max grade
        check[3].addActionListener(e -> {
            noEdit(userService, table);
            List<User> mediumStudents = userService.getStudents().stream()
                    .map(x -> (Student) x)
                    .filter(x-> x.getGrade() < 0.5 * 5)
                    .collect(Collectors.toList());
            userService.getRepository().setUsers(mediumStudents);
            table.updateUI();
        });

        //Filtering students with <25% max grade
        check[4].addActionListener(e -> {
            noEdit(userService, table);
            List<User> worstStudents = userService.getStudents().stream()
                    .map(x -> (Student) x)
                    .filter(x-> x.getGrade() < 0.25 * 5)
                    .collect(Collectors.toList());
            userService.getRepository().setUsers(worstStudents);
            table.updateUI();
        });

        //Filtering teachers only
        check[5].addActionListener(e -> {
            List<User> teachers = userService.getTeachers();
            noEdit(userService, table);
            userService.getRepository().setUsers(teachers);
            table.updateUI();
        });

        return panelCheck;
    }

    private static void noEdit(UserService userService, JTable table) {
        userService.getRepository().load();
        editHint.setText("Editing is prohibited now!");
        table.setEnabled(false);
        for (int i = 1; i < 5; i++) {
            buttons.getComponent(i).setEnabled(false);
        }
    }

    private static JTable mainTable(UserView userView) {
        JTable table = new JTable(userView);
        JTextField textField = new JTextField();
        textField.setFont(new Font("Serif", Font.PLAIN, 24));
        DefaultCellEditor dce = new DefaultCellEditor(textField);
        table.getColumnModel().getColumn(1).setCellEditor(dce);
        table.getColumnModel().getColumn(2).setCellEditor(dce);
        table.getColumnModel().getColumn(3).setCellEditor(dce);
        table.getColumnModel().getColumn(4).setCellEditor(dce);
        table.setFont(new Font("Serif", Font.PLAIN, 20));
        table.setRowHeight(24);
        return table;
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame.setDefaultLookAndFeelDecorated(false);
            createGUI();
        });
    }
}
