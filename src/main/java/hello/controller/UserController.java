package hello.controller;

import hello.entity.User;
import hello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by neviim 2 on 24/08/2017.
 */
@RestController
@RequestMapping(path="user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    private @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email, @RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping(path = "/all")
    private @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/get-one")
    private @ResponseBody User getOneUser(@RequestParam Integer id) {
        return userRepository.findOne(id);
    }

    @DeleteMapping(path = "delete")
    private @ResponseBody void deleteUser(@RequestParam Integer id) {
        userRepository.delete(id);
    }
}
