package accounting.repository;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FileRepository<T,R> implements Repository<T,R>{
    Path path;

    public FileRepository(Path path) {
        this.path = path;
    }
    public ArrayList<T> readFileWithItems() {
        ArrayList<T> items = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            items = ((ArrayList<T>) ois.readObject());
        } catch (EOFException e) {
            e.printStackTrace();
            return items;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    public void cleanFile() {
        try {
            FileWriter writer = new FileWriter(path.toFile(), false);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(ArrayList<T> allItem, R elements) {
        try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(path.toFile(), true))) {
            oss.writeObject(allItem);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeWithAppend(ArrayList<T> allUser,R elements, boolean append) {
        try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(path.toFile(), append))) {
            oss.writeObject(allUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
