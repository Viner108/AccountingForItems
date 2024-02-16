package by.andrukovich.accounting.service.user_service;

import by.andrukovich.accounting.entity.users.User;
import by.andrukovich.accounting.entity.users.UserMap;
import by.andrukovich.accounting.repository.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RegistrationProcessor {
    private ArrayList<User> users = new ArrayList<>();
    private UserMap userMap=new UserMap();
    private Repository repository;
    private Map<Integer, User> mapForUser = new HashMap<>();
    public RegistrationProcessor( Repository<User,UserMap> repository) {
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
