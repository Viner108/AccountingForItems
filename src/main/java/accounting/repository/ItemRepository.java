package accounting.repository;

import accounting.entify.items.Item;

import java.nio.file.Path;

public class ItemRepository extends FileRepository<Item>{
    public ItemRepository(Path path) {
        super(path);
    }
}
