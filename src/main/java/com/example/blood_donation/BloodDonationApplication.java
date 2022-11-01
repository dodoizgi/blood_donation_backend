package com.example.blood_donation;

import com.example.blood_donation.config.AdvertConfig;
import com.example.blood_donation.config.UserConfig;
import com.example.blood_donation.domain.Advert;
import com.example.blood_donation.repository.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import({AdvertConfig.class, UserConfig.class})
@SpringBootApplication()
public class BloodDonationApplication {

    @Autowired
    private AdvertRepository advertRepository;
    public static void main(String[] args) {
        SpringApplication.run(BloodDonationApplication.class, args);
    }

}
