import items.Item;
import room.*;

import java.io.*;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class Test {
    // id - категория предмета
    //  1-техника
    //  2-одежда
    //  3-еда
    //  4-другое
    public static void main(String[] args) throws IOException{
        Path path1 = Path.of("library", "Item.java");
        Path path2 = Path.of("library", "Place.java");
        Item computer = new Item("Computer", 1, 1, 1, 1);
        Item toy = new Item("Toy", 4, 2, 2, 2);
        Item sweet = new Item("Sweet", 3, 0.01, 0.05, 0.01);
        Item dress = new Item("Dress", 2, 0.01, 1, 1.5);
        Item trash = new Item("Trash", 4, 0.1, 0.04, 0.01);
        Table table = new Table("Table", 1, 2, 2);
        Bed bed = new Bed("Bed", 2, 3, 5);
        Suitcase suitcase = new Suitcase("Suitcase", 0.5, 1, 0.5);
        Floor floor = new Floor("Floor", 3, 4, 5);
        Armchair armchair = new Armchair("Armchair", 1, 1, 1.5);
        table.insert(computer);
        table.insert(toy);
        table.insert(computer);
        table.insert(computer);
        table.insert(computer);
        bed.insert(toy);
        bed.insert(toy);
        bed.insert(toy);
        bed.insert(toy);
        bed.insert(sweet);
        suitcase.insert(dress);
        table.insert(dress);
        floor.insert(trash);
        floor.insert(sweet);
        floor.insert(dress);
        floor.insert(computer);
        floor.insert(toy);
        armchair.insert(computer);
        armchair.insert(toy);
        armchair.insert(trash);
        armchair.insert(dress);
        table.answerSearch(computer);
        bed.answerSearch(sweet);
        bed.answerSearch(computer);
        table.movement(computer, bed);
        bed.remove(computer);
        bed.answerSearch(computer);
        randomPlace(sweet, bed, table, suitcase, floor, armchair);
        searchInThisRoom(computer, bed, suitcase, table, floor, armchair);
        cleanFile(path1);
        writeItem(path1, computer);
        writeItem(path1, toy);
        writeItem(path1, sweet);
        writeItem(path1, dress);
        writeItem(path1, trash);
        readFile(path1);
        cleanFile(path2);
        writePlace(path2, table);
        writePlace(path2, bed);
        writePlace(path2, suitcase);
        writePlace(path2, floor);
        writePlace(path2, armchair);
        readFile(path2);

    }

    public static void randomPlace(Item item, Place... places) {
        for (Place place : places) {
            if (place.volume() > item.volume() && place.indexCheck(item)) {
                place.insert(item);
                break;
            }
        }
    }

    public static void searchInThisRoom(Item item, Place... places) {
        for (Place place : places) {
            if (place.search(item)) {
                place.answerSearch(item);
            }
        }
    }

    public static void readFile(Path path) throws IOException {
        try (BufferedReader inputStream = new BufferedReader(new FileReader(path.toFile()))) {
            String collect = inputStream.lines()
                    .collect(Collectors.joining("\n"));
            System.out.println(collect);
        }
    }

    public static void writeItem(Path path, Item item) throws IOException {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path.toFile(), true))) {
            outputStream.write(item.toString().getBytes());
            outputStream.write(System.lineSeparator().getBytes());
        }
    }

    public static void cleanFile(Path path) {
        try {
            FileWriter writer = new FileWriter(path.toFile(), false);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writePlace(Path path, Place place) throws IOException {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path.toFile(), true))) {
            outputStream.write(place.toString().getBytes());
            outputStream.write(System.lineSeparator().getBytes());
        }
    }

}
