package by.andrukovich.accounting.service;

import by.andrukovich.accounting.entity.users.User;
import by.andrukovich.accounting.repository.Repository;
import by.andrukovich.accounting.service.user_service.LoginProcessor;
import by.andrukovich.accounting.service.user_service.RegistrationProcessor;
import by.andrukovich.accounting.entity.users.UserMap;

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
