package accounting.controller;

import accounting.AccountingForItemsApplication;
import accounting.entify.items.Item;
import accounting.entify.places.Place;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/item")
public class ItemController {
    private AccountingForItemsApplication accountingForItemsApplication;

    public ItemController() {
        accountingForItemsApplication = new AccountingForItemsApplication();
    }
    @GetMapping("/getItem")
    public Place getPlace(@RequestParam(name = "place") String placeName) {
        return accountingForItemsApplication.useOfThePlace(placeName);
    }


    @PostMapping("/postItem")
    public Item useOfTheItem(@RequestBody Body body) throws Exception {
        accountingForItemsApplication.createItem(body.name, body.id, body.width, body.length, body.height);
        return accountingForItemsApplication.useOfTheItem(body.name);
    }

    static class Body {
        public String name;
        public int id;
        public double width;
        public double length;
        public double height;
    }
}
