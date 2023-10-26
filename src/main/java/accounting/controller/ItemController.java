package accounting.controller;

import accounting.AccountingForItemsApplication;
import accounting.entify.items.Item;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/item")
public class ItemController {
    private AccountingForItemsApplication accountingForItemsApplication;

    public ItemController() {
        accountingForItemsApplication = new AccountingForItemsApplication();
    }

    @PostMapping("/Item")
    public String useOfTheItem(@RequestBody Body body) throws Exception {
        accountingForItemsApplication.createItem(body.name, body.id, body.width, body.length, body.height);
        return "[{\"user\":\"u1\", \"login\":\"L1\"}, {\"user\":\"u2\", \"login\":\"L2\"}]";
    }

    static class Body {
        public String name;
        public int id;
        public double width;
        public double length;
        public double height;
    }
}
