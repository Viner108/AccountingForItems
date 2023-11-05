package by.andrukovich.accounting.service;

import by.andrukovich.accounting.entify.items.Item;
import by.andrukovich.accounting.entify.items.ItemMap;
import by.andrukovich.accounting.repository.Repository;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ItemService {
    private Repository repository;
    private ArrayList<Item> items = new ArrayList<>();
    private ItemMap itemMap=new ItemMap();
    private Map<Integer, Item> mapForItem = new HashMap<>();
    public ItemService(Repository<Item,ItemMap> repository) {
        this.repository=repository;

    }

    public Item createItem(String name, int id, double width, double length, double height) throws JAXBException, Exception{
        Item item = new Item(name, id, width, length, height);
        items.add(item);
        mapForItem.put(items.size(), item);
        itemMap.setItemMap(mapForItem);
        repository.writeToFile( items,itemMap, false);
        return item;
    }

    public Item useOfTheItem(String name) throws Exception {
        Item item1 = null;
        Item item2 = null;
        Item item3 = null;
        ArrayList<Item> items2 = repository.readFileWithItems();
        ItemMap itemMap1 = (ItemMap) repository.readFromFile(itemMap);
        if(items2.size()!=0) {
            item1 = items2.stream().filter(item -> Objects.equals(item.getName(), name)).findFirst().get();
        }
        if(itemMap1.getItemMap() !=null) {
            item2 = itemMap1.getItemMap().values().stream().filter(item -> Objects.equals(item.getName(), name)).findFirst().get();
        }
        if (item1 != null) {
            return item1;
        } else if (item2 != null) {
            return item2;
        } else return item3;
    }
}
