package accounting.controller;

import accounting.AccountingForItemsApplication;
import accounting.entify.items.Item;
import accounting.entify.places.Place;
import accounting.entify.users.User;
import accounting.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(){
        userService = new UserService();
    }
    @GetMapping("/getUser")
    public User getUser(@RequestParam(name = "place") String userName,
                          @RequestParam(name = "place") String userPwd) throws Exception {
        return userService.useOfTheUser(userName, userPwd);
    }

    @PostMapping("/postUser")
    public User user(@RequestBody Body body) throws Exception {
        userService.createUser(body.login, body.pwd);
        return userService.useOfTheUser(body.login, body.pwd);
    }

    static class Body{
        public String pwd;
        public String login;
    }

}
