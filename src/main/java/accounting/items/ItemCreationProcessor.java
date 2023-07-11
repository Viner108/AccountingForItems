package accounting.items;

import accounting.repository.ItemRepository;
import accounting.repository.UserRepository;
import accounting.users.User;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

public class ItemCreationProcessor {
    private ItemRepository fileRepository = new ItemRepository();
    private Path path;
    private ArrayList<Item> items = new ArrayList<>();

    public ItemCreationProcessor(Path path) {
        this.path = path;
    }

    public Item createItem(String name, int id, double width, double length, double height) {
        Item item = new Item(name, id, width, length, height);
        items.add(item);
        fileRepository.writeObject(path, items, false);
        return item;
    }

    public Item useOfTheItem(String name) {
        Item item1 = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            ArrayList<Item> items1 = ((ArrayList<Item>) ois.readObject());
            for (Item item : items1) {
                if (Objects.equals(item.getName(), name)) {
                    item1 = item;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item1;
    }
}
