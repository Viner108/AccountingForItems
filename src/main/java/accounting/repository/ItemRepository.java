package accounting.repository;

import accounting.entify.items.Item;
import accounting.entify.items.ItemMap;

import java.nio.file.Path;

public class ItemRepository extends FileRepository<Item, ItemMap>{
    public ItemRepository(Path path) {
        super(path);
    }
}
