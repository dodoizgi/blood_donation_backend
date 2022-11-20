package com.example.blood_donation.controller;

import com.example.blood_donation.domain.Advert;
import com.example.blood_donation.domain.UserModule;
import com.example.blood_donation.repository.UserRepository;
import com.example.blood_donation.service.UserService;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/login")
    public List<UserModule> getUsersByEmailAndPassword(@RequestParam String mail, @RequestParam String password) {
       return userService.getUsersByMailAndPassword(mail, password);
    }

    @GetMapping("/adverts")
    public List<Advert> getUserAdverts(@RequestParam int id) {
        return userService.getUserAdverts(id);
    }

    @PostMapping
    public void registerNewUser(@RequestBody UserModule userModule) {userService.addNewUser(userModule);}

    @DeleteMapping(path = {"{userID}"})
    public void deleteUser(@PathVariable("userID") int userID) {
        userService.deleteUser(userID);
    }

    @PutMapping(path = {"{userId}"})
    public void updateUser(
        @PathVariable("userId") int userId,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String lastname,
        @RequestParam(required = false) String mail,
        @RequestParam(required = false) String password,
        @RequestParam(required = false) String phone) {
            userService.updateuser(userId, name, lastname, mail, password, phone);
    }
}
