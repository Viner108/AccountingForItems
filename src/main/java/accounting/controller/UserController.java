package accounting.controller;

import accounting.AccountingForItemsApplication;
import accounting.entify.items.Item;
import accounting.entify.places.Place;
import accounting.entify.users.User;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/user")
public class UserController {

    private AccountingForItemsApplication accountingForItemsApplication;

    public UserController(){
        accountingForItemsApplication = new AccountingForItemsApplication();
    }
    @GetMapping("/getUser")
    public User getUser(@RequestParam(name = "place") String userName,
                          @RequestParam(name = "place") String userPwd) throws Exception {
        return accountingForItemsApplication.loginUser(userName, userPwd);
    }

    @PostMapping("/postUser")
    public User user(@RequestBody Body body) throws Exception {
        accountingForItemsApplication.createUser(body.login, body.pwd);
        return accountingForItemsApplication.loginUser(body.login, body.pwd);
    }

    static class Body{
        public String pwd;
        public String login;
    }

}
