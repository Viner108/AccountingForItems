package accounting.service.user_service;

import accounting.entify.users.UserMap;
import accounting.repository.Repository;
import accounting.repository.UserRepository;
import accounting.entify.users.User;

import javax.xml.bind.JAXBException;
import java.nio.file.Path;
import java.util.ArrayList;

public class RegistrationProcessor {
    private Path path;
    private ArrayList<User> users = new ArrayList<>();
    private UserMap userMap=new UserMap();
    private Repository repository;
    public RegistrationProcessor(Path path, Repository<User,UserMap> repository) {
        this.path = path;
        this.repository=repository;
    }

    public User createUser(String login, String password) throws JAXBException, Exception{
        User user = new User(login,hashCode(),password);
        users.add(user);
        UserRepository fileRepository = new UserRepository(path);
        fileRepository.writeToFile(users,userMap,false);
        return user;
    }
}
