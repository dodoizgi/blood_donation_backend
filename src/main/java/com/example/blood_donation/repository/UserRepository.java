package com.example.blood_donation.repository;

import com.example.blood_donation.domain.UserModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModule, Integer> {

}
