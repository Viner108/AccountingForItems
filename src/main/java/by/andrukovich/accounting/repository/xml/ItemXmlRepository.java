package by.andrukovich.accounting.repository.xml;

import by.andrukovich.accounting.entity.items.Item;
import by.andrukovich.accounting.entity.items.ItemMap;

import java.nio.file.Path;

public class ItemXmlRepository extends FileXmlRepository<Item,ItemMap>{
    public ItemXmlRepository(Path path) {
        super(path);
    }
}
