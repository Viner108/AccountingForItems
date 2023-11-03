package accounting.service;

import accounting.entify.users.User;
import accounting.entify.users.UserMap;
import accounting.repository.Repository;
import accounting.service.user_service.LoginProcessor;
import accounting.service.user_service.RegistrationProcessor;

import java.nio.file.Path;

public class UserService {
    private Repository repository;
    private LoginProcessor loginProcessor = new LoginProcessor( repository);
    private RegistrationProcessor registrationProcessor = new RegistrationProcessor( repository);

    public UserService( Repository<User, UserMap> repository) {
        this.repository=repository;
    }
    public User createUser(String login, String password) throws Exception {
        User user = registrationProcessor.createUser(login, password);
        return user;
    }
    public User useOfTheUser(String login, String password) throws Exception {
        User user = loginProcessor.login(login, password);
        return user;
    }
}
