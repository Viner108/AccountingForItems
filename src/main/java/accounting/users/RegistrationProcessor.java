package accounting.users;

import accounting.FileRepository;
import org.apache.commons.lang3.SerializationUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RegistrationProcessor {
    private FileRepository fileRepository = new FileRepository();
    private Path path;

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
        User user = null;
        try {
            user = new User(login, hashCode(), password);
            UserList list= null;
            try {
                list=(UserList) readFile(path);
            }catch (Exception e){
                e.printStackTrace();
            }
            if(list==null){
                list=new UserList();
            }
            list.add(user);
            fileRepository.writeUserAsList(path, list);
        } catch (IOException e) {
            e.printStackTrace();
            user = null;
        }
        return user;
    }
}
