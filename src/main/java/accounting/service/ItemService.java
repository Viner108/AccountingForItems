package accounting.service;

import accounting.entify.items.Item;
import accounting.entify.items.ItemMap;
import accounting.repository.ItemRepository;
import accounting.repository.Repository;

import javax.xml.bind.JAXBException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

public class ItemService {
    private Path path;
    private ArrayList<Item> items = new ArrayList<>();
    private ItemMap itemMap=new ItemMap();
    private Repository repository;
    public ItemService(Path path, Repository<Item,ItemMap> repository) {
        this.path = path;
        this.repository=repository;

    }

//    private ItemRepository fileRepository = new ItemRepository(path);

    public Item createItem(String name, int id, double width, double length, double height) throws JAXBException, Exception{
        Item item = new Item(name, id, width, length, height);
        items.add(item);
        ItemRepository fileRepository = new ItemRepository(path);
        fileRepository.writeToFile( items,itemMap, false);
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
