package by.andrukovich.accounting.controller;

import by.andrukovich.accounting.repository.ItemRepository;
import by.andrukovich.accounting.entity.items.Item;
import by.andrukovich.accounting.entity.items.ItemMap;
import by.andrukovich.accounting.repository.Repository;
import by.andrukovich.accounting.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RestController()
@RequestMapping("/item")
public class ItemController {
    private ItemService itemService;
    private Path itemPath = Path.of("library", "Item.java");
    private Repository<Item, ItemMap> itemRepository1 = new ItemRepository(itemPath);

    public ItemController() {
        itemService = new ItemService(itemRepository1);
    }
    @GetMapping("/getItem")
    public Item getItem(@RequestParam(name = "item") String itemName) throws Exception {
        return itemService.useOfTheItem(itemName);
    }


    @PostMapping("/postItem")
    public Item useOfTheItem(@RequestBody Body body) throws Exception {
        itemService.createItem(body.name, body.id, body.width, body.length, body.height);
        return itemService.useOfTheItem(body.name);
    }

    static class Body {
        public String name;
        public int id;
        public double width;
        public double length;
        public double height;
    }
}
