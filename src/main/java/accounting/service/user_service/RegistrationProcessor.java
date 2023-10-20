package accounting.service.user_service;

import accounting.entify.users.UserMap;
import accounting.repository.UserRepository;
import accounting.entify.users.User;

import java.nio.file.Path;
import java.util.ArrayList;

public class RegistrationProcessor {
    private Path path;
    private ArrayList<User> users = new ArrayList<>();
    private UserMap userMap=new UserMap();
    public RegistrationProcessor(Path path) {
        this.path = path;
    }

    public User createUser(String login, String password) {
        User user = new User(login,hashCode(),password);
        users.add(user);
        UserRepository fileRepository = new UserRepository(path);
        fileRepository.writeWithAppend(users,userMap,false);
        return user;
    }
}
