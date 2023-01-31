package OOPSem4.Homework4.impls;

import OOPSem4.Homework4.Model.Student;
import OOPSem4.Homework4.Model.Teacher;
import OOPSem4.Homework4.Model.User;
import OOPSem4.Homework4.Repository.UserRepository;
import OOPSem4.Homework4.Service.UserService;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private UserRepository<User> repository = new UserRepository<>();

    @Override
    public void add(User user) {
        repository.save(user);
    }

    public UserRepository<User> getRepository() {
        return repository;
    }


    public List<Student> getOver75SAverageGradeStudents() {
        OptionalDouble averageValue = getAllUsers().stream()
                .map(x-> (Student) x)
                .map(Student::getGrade)
                .map(Double.class::cast)
                .mapToDouble(Double::doubleValue)
                .average();

        return getAllUsers().stream()
                .map(x -> (Student) x)
                .filter(x-> x.getGrade() > averageValue.getAsDouble())
                .collect(Collectors.toList());
    }

    @Override
    public void remove(User user) {
        repository.remove(user);
    }

    public void remove(int index) {
        repository.remove(index);
    }

    @Override
    public void edit(User user, User updateUser) {
        List<User> users = repository.getUsers();
        if (users.contains(user)) {
            users.remove(user);
            users.add(updateUser);
            repository.saveAll(users);
        }
    }

    @Override
    public void print(User user) {
        List<User> users = repository.getUsers();
        if (users.contains(user)) {
            int index = users.indexOf(user);
            System.out.println(users.get(index));
        }
    }

    @Override
    public List<User> getAllUsers() {
        return repository.getUsers();
    }

    @Override
    public User get(User user) {
        return repository.getUser(user);
    }

    @Override
    public void saveAll(List<User> users) {
        repository.saveAll(users);
    }

    @Override
    public List<User> getStudents() {
        return getAllUsers().stream()
                .filter(Student.class::isInstance)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getTeachers() {
        return getAllUsers().stream()
                .filter(Teacher.class::isInstance)
                .collect(Collectors.toList());
    }
}
