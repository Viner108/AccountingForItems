import items.Documents;
import items.Item;
import items.Medicines;
import items.SpareParts;
import room.*;

import java.io.*;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class AccountingForItemsApplication {

    public static void create() throws IOException{
        Path path1 = Path.of("library", "Item.java");
        Path path2 = Path.of("library", "Place.java");
        // id - категория предмета
        //  1-техника
        //  2-одежда
        //  3-еда
        //  4-инструменты
        //  5-документы
        //  6-лекарства
        //  7-другое
        Item computer = new Item("Computer", 1, 1, 1, 1);
        Item toy = new Item("Toy", 7, 2, 2, 2);
        Item sweet = new Item("Sweet", 3, 0.01, 0.05, 0.01);
        Item dress = new Item("Dress", 2, 0.01, 1, 1.5);
        Item trash = new Item("Trash", 7, 0.1, 0.04, 0.01);
        Item hammock=new Item("Hammock",7,1.5,2,0.01);
        Documents document=new Documents("Contract",5,0.2,0.5,0.0001,31536000);
        Medicines medicine=new Medicines("Pills",6,0.02,0.05,0.005,7776000);
        SpareParts part=new SpareParts("Rope",7,0.01,3,0.01,hammock);
        Table table = new Table("Table", 1, 2, 2);
        Bed bed = new Bed("Bed", 2, 3, 5);
        Suitcase suitcase = new Suitcase("Suitcase", 0.5, 1, 0.5);
        Floor floor = new Floor("Floor", 3, 4, 5);
        Armchair armchair = new Armchair("Armchair", 1, 1, 1.5);
        cleanFile(path1);
        writeAllItem(path1,computer,toy,sweet,dress,trash,hammock,document,medicine,part);
        readFile(path1);
        cleanFile(path2);
       writeAllPlace(path2,armchair,bed,floor,suitcase,table);
        readFile(path2);
    }
    public static void writeAllItem(Path path,Item...items) throws IOException {
        for (Item item : items) {
            writeItem(path,item);
        }
    }
    public static void writeAllPlace(Path path,Place...places) throws IOException{
        for (Place place : places) {
            writePlace(path,place);
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
