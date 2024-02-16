package by.andrukovich.accounting.repository;

import by.andrukovich.accounting.entity.items.Item;
import by.andrukovich.accounting.entity.items.ItemMap;

import java.nio.file.Path;

public class ItemRepository extends FileRepository<Item, ItemMap>{
    public ItemRepository(Path path) {
        super(path);
    }
}
