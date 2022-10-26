package com.example.blood_donation.repository;

import com.example.blood_donation.domain.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Integer> {

    @Query("SELECT a FROM Advert a WHERE a.bloodGroup = ?1")
    Optional<Advert> findAdvertByBloodGroup(String bloodgroup);
}
