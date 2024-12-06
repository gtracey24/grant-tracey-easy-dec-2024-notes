package com.notes.controllers;

import com.notes.entities.User;
import com.notes.repositories.UserRepository;
import com.notes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//@RestController annotation combines @Controller and @ResponseBody
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //Create
    @PostMapping("/user/create")
    @ResponseStatus(HttpStatus.OK)
    public User createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }

    //Read
    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public List<User> fetchUserList()
    {
        return userService.fetchUserList();
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> findUserById(@PathVariable("id")
                                           Integer userId)
    {
        return userService.findUserById(userId);
    }

    //Update
    @PutMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User
    updateUser(@RequestBody User user,
               @PathVariable("id") Integer userId)
    {
        return userService.updateUser(
                user, userId
        );
    }

    //Delete
    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteUserById(@PathVariable("id")
                                 Integer userId)
    {
        userService.deleteUserById(
                userId);
        return "Deleted Successfully";
    }
}
