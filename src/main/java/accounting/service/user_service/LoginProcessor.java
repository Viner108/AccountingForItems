package accounting.service.user_service;

import accounting.entify.users.UserMap;
import accounting.repository.Repository;
import accounting.repository.UserRepository;
import accounting.entify.users.User;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

public class LoginProcessor {
    private Repository<User, UserMap> repository;

    public LoginProcessor( Repository<User, UserMap> repository) {
        this.repository = repository;
    }

    public User login(String login, String password) throws Exception {
        User user1 = null;
        User user2 = null;
        User user3 = null;
        ArrayList<User> users2 = repository.readFileWithItems();
        UserMap userMap = new UserMap();
        UserMap userMap1 = repository.readFromFile(userMap);
        if(users2.size()!=0) {
            user1 = users2.stream().filter(user -> user.getName().equals(login) && user.getPassword().equals(password)).findFirst().get();
        }
        if(userMap1.getUserMap() !=null) {
            user2 = userMap1.getUserMap().values().stream().filter(user -> user.getName().equals(login) && user.getPassword().equals(password)).findFirst().get();
        }
        if (user1 != null) {
            return user1;
        } else if (user2 != null) {
            return user2;
        } else return user3;
    }

    public boolean isUser(String name, String password) throws Exception {
        if (login(name, password) != null) {
            return true;
        }
        return false;
    }
}
