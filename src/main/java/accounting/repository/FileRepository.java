package accounting.repository;

import accounting.items.Item;
import accounting.room.Place;
import accounting.users.ActionLog;
import accounting.users.User;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileRepository<T> {
    public void writeAll(Path path, T... items) {
        ArrayList<T> allItem = new ArrayList<>();
        for (T item : items) {
            allItem.add(item);
        }
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


    public void writeUser(Path path, ArrayList<T> allUser, boolean append) {
        try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(path.toFile(), append))) {
            oss.writeObject(allUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeAction(Path path, ActionLog log) throws IOException {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path.toFile(), true))) {
            outputStream.write(log.toString().getBytes());
            outputStream.write(System.lineSeparator().getBytes());
        }
    }
}
