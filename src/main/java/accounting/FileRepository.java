package accounting;

import accounting.items.Item;
import accounting.room.Place;
import accounting.users.ActionLog;
import accounting.users.User;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileRepository {
    public void writeAllItem(Path path,Item...items) throws IOException {
        for (Item item : items) {
            writeItem(path,item);
        }
    }
    public void writeAllPlace(Path path,Place...places) throws IOException{
        for (Place place : places) {
            writePlace(path,place);
        }
    }
    public void writeAllUser(Path path,User...users) throws IOException{
        for (User user:users){
            writeUser(path,user);
        }
    }
    public String readFile(Path path) throws IOException {
        String collect=null;
        try (BufferedReader inputStream = new BufferedReader(new FileReader(path.toFile()))) {
            collect = inputStream.lines()
                    .collect(Collectors.joining("\n"));
            System.out.println(collect);
        }
        return collect;
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

    public void writeItem(Path path, Item item) throws IOException {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path.toFile(), true))) {
            outputStream.write(item.toString().getBytes());
            outputStream.write(System.lineSeparator().getBytes());
        }
    }

    public void writePlace(Path path, Place place) throws IOException {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path.toFile(), true))) {
            outputStream.write(place.toString().getBytes());
            outputStream.write(System.lineSeparator().getBytes());
        }
    }
    public void writeUser(Path path, User user) throws IOException{
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path.toFile(), true))){
            outputStream.write(user.toString().getBytes());
            outputStream.write(System.lineSeparator().getBytes());
        }
    }
    public void writeUserAsObject(Path path, User user) throws IOException{
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path.toFile(), true))){
            outputStream.writeObject(user);
        }
    }
    public void writeUserAsList(Path path, List<User> users) throws IOException{
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path.toFile(), true))){
            outputStream.writeObject(users);
        }
    }
    public void writeAction(Path path, ActionLog log) throws IOException{
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path.toFile(), true))){
            outputStream.write(log.toString().getBytes());
            outputStream.write(System.lineSeparator().getBytes());
        }
    }
}
