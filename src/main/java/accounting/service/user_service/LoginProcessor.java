package accounting.service.user_service;

import accounting.entify.users.UserMap;
import accounting.repository.Repository;
import accounting.repository.UserRepository;
import accounting.entify.users.User;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

public class LoginProcessor {
    private Path path;
    private Repository<User,UserMap> repository;

    public LoginProcessor(Path path, Repository<User, UserMap> repository) {
        this.path = path;
        this.repository = repository;
    }

    public User login(String login, String password) {
        User user1 = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            ArrayList<User> users = ((ArrayList<User>) ois.readObject());
            user1 = users.stream().filter(user -> user.getName().equals(login) && user.getPassword().equals(password)).findFirst().get();

//           for (User user:users){
//               if(Objects.equals(user.getName(), login) && Objects.equals(user.getPassword(), password)){
//                   user1=user;
//               }
//           }
        } catch (EOFException e) {
            System.out.println("");
            System.out.println("End of file reached");
            return user1;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user1;
    }

    public boolean isUser(String name, String password) {
        if (login(name, password) != null) {
            return true;
        }
        return false;
    }
}
