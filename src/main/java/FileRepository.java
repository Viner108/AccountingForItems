import items.Item;
import items.Medicines;
import room.Place;
import users.User;

import java.io.*;
import java.nio.file.Path;
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
    public void readFile(Path path) throws IOException {
        try (BufferedReader inputStream = new BufferedReader(new FileReader(path.toFile()))) {
            String collect = inputStream.lines()
                    .collect(Collectors.joining("\n"));
            System.out.println(collect);
        }
    }

    public void writeItem(Path path, Item item) throws IOException {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path.toFile(), true))) {
            outputStream.write(item.toString().getBytes());
            outputStream.write(System.lineSeparator().getBytes());
        }
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
}
