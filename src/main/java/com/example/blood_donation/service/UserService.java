package com.example.blood_donation.service;

import com.example.blood_donation.domain.Advert;
import com.example.blood_donation.domain.UserModule;
import com.example.blood_donation.repository.AdvertRepository;
import com.example.blood_donation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AdvertRepository advertRepository;

    @Autowired
    public UserService(UserRepository userRepository, AdvertRepository advertRepository) {
        this.userRepository = userRepository;
        this.advertRepository = advertRepository;
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

    public List<Advert> getUserAdverts(int id) {
        List<Advert> advertList = advertRepository.findAdvertByUserId(id);
        if (advertList.isEmpty()) {
            throw new IllegalStateException("Advert not found");
        }
        return advertRepository.findAdvertByUserId(id);
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
}
