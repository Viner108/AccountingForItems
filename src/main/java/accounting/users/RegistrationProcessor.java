package accounting.users;

import accounting.FileRepository;
import org.apache.commons.lang3.SerializationUtils;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RegistrationProcessor {
    private FileRepository fileRepository = new FileRepository();
    private Path path;
    private ArrayList<User> users = new ArrayList<>();

    public RegistrationProcessor(Path path) {
        this.path = path;
    }
    private Object readFile(Path path){
        try {
            try (ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(path.toFile()))){
                Object list=(Object)objectInputStream.readObject();
                return list;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User createUser(String login, String password) {
        User user = new User(login,hashCode(),password);
        users.add(user);
        fileRepository.writeUser(path,users,false);
        return user;
    }
}
