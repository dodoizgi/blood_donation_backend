package com.example.blood_donation.controller;

import com.example.blood_donation.domain.UserModule;
import com.example.blood_donation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModule> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public void registerNewUser(@RequestBody UserModule userModule) {userService.addNewUser(userModule);}

    @DeleteMapping(path = {"{userID}"})
    public void deleteUser(@PathVariable("userID") int userID) {
        userService.deleteUser(userID);
    }

    @PutMapping(path = "{userId}")
    public void updateUser() {

    }
}
