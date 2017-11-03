package services.Controller;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import services.service.UserServiceImpl;

import java.util.List;

@RestController/*(value = "/user")*/
public class UserConroller {

    @Autowired
    UserServiceImpl userService;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable Long id){
        User user = userService.takeUser(id);
        return user;
    }

    @GetMapping(value = "/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers(){
        List<User> users = userService.takeAll();
        return users;
    }

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestBody User user){
        userService.saveUser(user);
        return user;
    }
}
