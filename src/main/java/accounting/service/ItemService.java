package accounting.service;

import accounting.entify.items.Item;
import accounting.repository.ItemRepository;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

public class ItemService {
    private Path path;
    private ArrayList<Item> items = new ArrayList<>();
    public ItemService(Path path) {
        this.path = path;
    }

    private ItemRepository fileRepository = new ItemRepository(path);

    public Item createItem(String name, int id, double width, double length, double height) {
        Item item = new Item(name, id, width, length, height);
        items.add(item);
        fileRepository.writeWithAppend( items, false);
        return item;
    }

    public Item useOfTheItem(String name) {
        Item item1 = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            ArrayList<Item> items1 = ((ArrayList<Item>) ois.readObject());
            item1 = items1.stream().filter(item -> Objects.equals(item.getName(), name)).findFirst().get();
//            for (Item item : items1) {
//                if (Objects.equals(item.getName(), name)) {
//                    item1 = item;
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item1;
    }
}
