package accounting.service.user_service;

import accounting.entify.users.UserMap;
import accounting.repository.Repository;
import accounting.repository.UserRepository;
import accounting.entify.users.User;

import javax.xml.bind.JAXBException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RegistrationProcessor {
    private Path path;
    private ArrayList<User> users = new ArrayList<>();
    private UserMap userMap=new UserMap();
    private Repository repository;
    private Map<Integer, User> mapForUser = new HashMap<>();
    public RegistrationProcessor(Path path, Repository<User,UserMap> repository) {
        this.path = path;
        this.repository=repository;
    }

    public User createUser(String login, String password) throws Exception{
        User user = new User(login,hashCode(),password);
        users.add(user);
        mapForUser.put(users.size(), user);
        userMap.setUserMap(mapForUser);
        repository.writeToFile(users,userMap,false);
        return user;
    }
}
