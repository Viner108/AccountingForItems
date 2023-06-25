package accounting.users;

import accounting.FileRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class LoginProcessor {
    private FileRepository fileRepository = new FileRepository();
    private Path path;

    public LoginProcessor(Path path) {
        this.path = path;
    }
    public User login(String login, String password) {
        User user=null;
        try {
            String line=fileRepository.readFile(path);
            line.split("\n");
            try (ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(path.toFile()))){
                Object object=(List)objectInputStream.readObject();
                object.toString();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
//            Stream.of(line.split("\n")).
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
