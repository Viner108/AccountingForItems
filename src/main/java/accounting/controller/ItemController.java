package accounting.controller;

import accounting.AccountingForItemsApplication;
import accounting.entify.items.Item;
import accounting.entify.places.Place;
import accounting.service.ItemService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/item")
public class ItemController {
    private ItemService itemService;

    public ItemController() {
        itemService = new ItemService();
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
