package accounting.users;

import accounting.repository.UserRepository;

import java.nio.file.Path;
import java.util.ArrayList;

public class RegistrationProcessor {
    private UserRepository fileRepository = new UserRepository();
    private Path path;
    private ArrayList<User> users = new ArrayList<>();

    public RegistrationProcessor(Path path) {
        this.path = path;
    }

    public User createUser(String login, String password) {
        User user = new User(login,hashCode(),password);
        users.add(user);
        fileRepository.writeObject(path,users,false);
        return user;
    }
}
