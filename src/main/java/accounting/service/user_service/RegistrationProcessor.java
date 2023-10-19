package accounting.service.user_service;

import accounting.repository.UserRepository;
import accounting.entify.users.User;

import java.nio.file.Path;
import java.util.ArrayList;

public class RegistrationProcessor {
    private Path path;
    private ArrayList<User> users = new ArrayList<>();
    public RegistrationProcessor(Path path) {
        this.path = path;
    }

    private UserRepository fileRepository = new UserRepository(path);

    public User createUser(String login, String password) {
        User user = new User(login,hashCode(),password);
        users.add(user);
        fileRepository.writeWithAppend(users,false);
        return user;
    }
}
