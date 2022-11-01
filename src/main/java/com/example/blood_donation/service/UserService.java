package com.example.blood_donation.service;

import com.example.blood_donation.domain.UserModule;
import com.example.blood_donation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
