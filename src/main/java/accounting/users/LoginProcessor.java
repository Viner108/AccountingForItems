package accounting.users;

import accounting.FileRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LoginProcessor {
    private FileRepository fileRepository = new FileRepository();
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
