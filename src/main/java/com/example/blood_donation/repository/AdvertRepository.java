package com.example.blood_donation.repository;

import com.example.blood_donation.domain.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Integer> {

    List<Advert> findAdvertByUserId(int id);

}
