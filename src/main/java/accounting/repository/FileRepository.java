package accounting.repository;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class FileRepository<T> {
    public void writeAll(Path path, T... items) {
        ArrayList<T> allItem = new ArrayList<>();
        Arrays.stream(items).forEach(item ->allItem.add(item));
//        for (T item : items) {
//            allItem.add(item);
//        }
        write(path, allItem);
    }
    public ArrayList<T> readFileWithItems(Path path) {
        ArrayList<T> items = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            items = ((ArrayList<T>) ois.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public void cleanFile(Path path) {
        try {
            FileWriter writer = new FileWriter(path.toFile(), false);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(Path path, ArrayList<T> allItem) {
        try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(path.toFile(), true))) {
            oss.writeObject(allItem);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeObject(Path path, ArrayList<T> allUser, boolean append) {
        try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(path.toFile(), append))) {
            oss.writeObject(allUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
