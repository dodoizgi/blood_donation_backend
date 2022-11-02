package com.example.blood_donation.repository;

import com.example.blood_donation.domain.Advert;
import com.example.blood_donation.domain.UserModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModule, Integer> {
    List<UserModule> findUserModuleByMailAndPassword(String mail, String password);
}
