package OOPSem4.Homework4.impls;

import OOPSem4.Homework4.Model.User;
import OOPSem4.Homework4.Repository.UserRepository;
import OOPSem4.Homework4.Service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository<User> repository = new UserRepository<>();

    @Override
    public void add(User user) {
        repository.save(user);
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
}
