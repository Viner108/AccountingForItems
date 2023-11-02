package accounting.controller;

import accounting.AccountingForItemsApplication;
import accounting.entify.places.Place;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/place")
public class PlaceController {
    private AccountingForItemsApplication accountingForItemsApplication;

    public PlaceController() {
        accountingForItemsApplication = new AccountingForItemsApplication();
    }
    @GetMapping("/getPlace")
    public Place getPlace(@RequestParam(name = "place") String placeName) {
        return accountingForItemsApplication.useOfThePlace(placeName);
    }

    @PostMapping("/postPlace")
    public Place postPlace(@RequestBody Body body) throws Exception {
        accountingForItemsApplication.createPlace(body.name, body.width, body.length, body.height);
        return accountingForItemsApplication.useOfThePlace(body.name);
    }

    static class Body {
        public String name;
        public double width;
        public double length;
        public double height;
    }
}
