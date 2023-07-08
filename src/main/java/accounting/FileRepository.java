package accounting;

import accounting.items.Item;
import accounting.room.Place;
import accounting.users.ActionLog;
import accounting.users.User;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileRepository {
    public void writeAllItem(Path path, Item... items) {
        ArrayList<Item> allItem = new ArrayList<>();
        for (Item item : items) {
            allItem.add(item);
        }
        writeItem(path, allItem);
    }

    public void writeAllPlace(Path path, Place... places){
        ArrayList<Place> allPlace = new ArrayList<>();
        for (Place place : places) {
            allPlace.add(place);
        }
        writePlace(path, allPlace);
    }

    public ArrayList<Item> readFileWithItems(Path path) {
        ArrayList<Item> items = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            items = ((ArrayList<Item>) ois.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }public ArrayList<Place> readFileWithPlaces(Path path) {
        ArrayList<Place> places = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            places = ((ArrayList<Place>) ois.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return places;
    }public ArrayList<User> readFileWithUsers(Path path) {
        ArrayList<User> users = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            users = ((ArrayList<User>) ois.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
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

    public void writeItem(Path path, ArrayList<Item> allItem){
        try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(path.toFile(), true))) {
            oss.writeObject(allItem);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writePlace(Path path, ArrayList<Place> allPlace){
        try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(path.toFile(), true))) {
            oss.writeObject(allPlace);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeUser(Path path, ArrayList<User> allUser, boolean append) {
        try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(path.toFile(), append))) {
            oss.writeObject(allUser);
        }catch (IOException e){
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
