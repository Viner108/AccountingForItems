package accounting.repository;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class FileRepository<T> implements Repository<T>{
    Path path;

    public FileRepository(Path path) {
        this.path = path;
    }

    public void writeAll( T... items) {
        ArrayList<T> allItem = new ArrayList<>();
        Arrays.stream(items).forEach(item ->allItem.add(item));
//        for (T item : items) {
//            allItem.add(item);
//        }
        write(allItem);
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

    public void write( ArrayList<T> allItem) {
        try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(path.toFile(), true))) {
            oss.writeObject(allItem);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeWithAppend(ArrayList<T> allUser, boolean append) {
        try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(path.toFile(), append))) {
            oss.writeObject(allUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
