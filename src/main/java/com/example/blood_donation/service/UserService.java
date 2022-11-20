package com.example.blood_donation.service;

import com.example.blood_donation.domain.Advert;
import com.example.blood_donation.domain.UserModule;
import com.example.blood_donation.repository.AdvertRepository;
import com.example.blood_donation.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

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

    @Transactional
    public void updateuser(int userId, String name, String lastname, String mail, String password, String phone) {
        UserModule user = userRepository.findById(userId).orElseThrow(() ->
                new IllegalStateException(
                        "user with id " + userId + " does not exists"
                ));

        if (name != null &&
                !Objects.equals(user.getName(),name)) {
            user.setName(name);
        }

        if (lastname != null &&
                !Objects.equals(user.getLastname(),lastname)) {
            user.setLastname(lastname);
        }

        if (mail != null &&
                !Objects.equals(user.getMail(),mail)) {
            user.setMail(mail);
        }

        if (password != null &&
                !Objects.equals(user.getPassword(),password)) {
            user.setPassword(password);
        }

        if (phone != null &&
                !Objects.equals(user.getPhone(),phone)) {
            user.setPhone(phone);
        }

    }
}
