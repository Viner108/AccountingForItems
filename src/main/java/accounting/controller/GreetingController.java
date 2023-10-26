package accounting.controller;

import accounting.AccountingForItemsApplication;
import accounting.entify.items.Item;
import accounting.entify.places.Place;
import accounting.entify.users.User;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/v1/user")
public class GreetingController {

    private AccountingForItemsApplication accountingForItemsApplication;

    public GreetingController(){
        accountingForItemsApplication = new AccountingForItemsApplication();
    }

    @GetMapping("/itemPath")
    public String getItemPath() {
        return accountingForItemsApplication.getItemPath().toString();
    }

    @GetMapping("/useOfTheItem")
    public Item useOfTheItem(@RequestParam(name = "item") String itemName) {
        return accountingForItemsApplication.useOfTheItem(itemName);
    }
    @GetMapping("/place")
    public Place place(@RequestParam(name = "place") String placeName) {
        return accountingForItemsApplication.useOfThePlace(placeName);
    }
    @PostMapping("/test")
    public String test(@RequestBody Body body) {
        return "[{\"user\":\"u1\", \"login\":\"L1\"}, {\"user\":\"u2\", \"login\":\"L2\"}]";
    }

    @PostMapping("/loginUser")
    public User greeting(@RequestParam(name = "login") String login,
                         @RequestParam(name = "pwd") String pwd,
                         @RequestBody Body body) throws Exception {
        return accountingForItemsApplication.loginUser(body.login, body.pwd);
    }

    static class Body{
        public String pwd;
        public String login;
    }

}
