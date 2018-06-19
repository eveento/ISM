package net.javabeat.spring.data.web;

import net.javabeat.spring.data.domain.User;
import net.javabeat.spring.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UsersController {
    @Autowired
    UserService userService;

    @RequestMapping(value="", method=RequestMethod.POST)
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @RequestMapping(value="", method=RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @RequestMapping(value="/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public User login(@RequestParam String login, @RequestParam String password){
        return userService.checkLogin(login, password);
    }

}
