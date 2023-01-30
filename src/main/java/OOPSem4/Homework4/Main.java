package OOPSem4.Homework4;
import OOPSem4.Homework4.Model.Student;
import OOPSem4.Homework4.Model.Teacher;
import OOPSem4.Homework4.Model.User;
import OOPSem4.Homework4.Service.UserService;
import OOPSem4.Homework4.View.UserView;
import OOPSem4.Homework4.impls.UserServiceImpl;

import java.awt.*;
import java.util.List;

import javax.swing.*;

public class Main extends JFrame {
    private static int generatingCounter = 0;

    public static void createGUI() {

        UserService userService = new UserServiceImpl();
        List<User> userList = userService.getAllUsers();
        UserView userView = new UserView(userList);

        JFrame frame = new JFrame("List of Teachers and Students - combined");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTable table = getjTable(userView);

        JPanel buttons = getjPanel(userService, userList, table);
        JPanel myText = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JScrollPane scrollPane = new JScrollPane(table);

        frame.getContentPane().add(scrollPane);
        frame.getContentPane().add(buttons, "South");

        frame.setPreferredSize(new Dimension(1450, 800));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JPanel getjPanel(UserService userService, List<User> userList, JTable table) {
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
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
        JLabel label1 = new JLabel("Edit Name, Grade, Year and Teacher");
        buttons.add(label1);

        buttons.add(addStudent);
        buttons.add(addTeacher);
        buttons.add(removeTile);
        buttons.add(saveAll);
        return buttons;
    }

    private static JTable getjTable(UserView userView) {
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
