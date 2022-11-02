package com.example.blood_donation.service;

import com.example.blood_donation.domain.UserModule;
import com.example.blood_donation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<UserModule> getUsers() {
        return userRepository.findAll();
    }

    public List<UserModule> getUsersByMailAndPassword(String mail, String password) {
        List<UserModule> UserModuleOptinal = userRepository.findUserModuleByMailAndPassword(mail, password);
        if (UserModuleOptinal.isEmpty()) {
            throw new IllegalStateException("User not found");
        }
        return userRepository.findUserModuleByMailAndPassword(mail, password);
    }

    public void addNewUser(UserModule userModule) {
        userRepository.save(userModule);
    }

    public void deleteUser(int userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException(
                    "advert with id " + userId + " does not exits"
            );
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(int userId, String userName, String userPhone) {

    }
}
