package accounting.users;

import accounting.repository.FileRepository;
import accounting.repository.UserRepository;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

public class LoginProcessor {
    private UserRepository fileRepository = new UserRepository();
    private Path path;

    public LoginProcessor(Path path) {
        this.path = path;
    }
    public User login(String login, String password) {
        User user1=null;
       try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
           ArrayList<User> users=((ArrayList<User>) ois.readObject());
           for (User user:users){
               if(Objects.equals(user.getName(), login) && Objects.equals(user.getPassword(), password)){
                   user1=user;
               }
           }
       }catch (Exception e){
           e.printStackTrace();
       }
        return user1;
    }
    public boolean isUser(String name, String password){
        if(login(name,password)!=null){
            return true;
        }
        return false;
    }
}
