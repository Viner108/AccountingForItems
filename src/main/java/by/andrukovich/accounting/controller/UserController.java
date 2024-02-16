package by.andrukovich.accounting.controller;

import by.andrukovich.accounting.entity.users.User;
import by.andrukovich.accounting.entity.users.UserMap;
import by.andrukovich.accounting.repository.Repository;
import by.andrukovich.accounting.repository.UserRepository;
import by.andrukovich.accounting.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RestController()
@RequestMapping("/user")
public class UserController {
    private Path userPath = Path.of("library", "User.java");
    private Repository<User, UserMap> userRepository1 = new UserRepository(userPath);

    private UserService userService;

    public UserController(){
        userService = new UserService(userRepository1);
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
