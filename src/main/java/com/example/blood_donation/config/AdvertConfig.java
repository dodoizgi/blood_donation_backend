package com.example.blood_donation.config;

import com.example.blood_donation.domain.Advert;
import com.example.blood_donation.repository.AdvertRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AdvertConfig {
    @Bean
    CommandLineRunner commandLineRunner(AdvertRepository repository) {
        return args -> {
            Advert ali = new Advert(
                    1,
            "b",
            "+",
            "5556789654",
            "kartal lutfi kirdar",
            "acilll"
            );

            Advert ayse = new Advert(
                    2,
                    "a",
                    "-",
                    "5356789654",
                    "maltepe devlet",
                    "yardimmm"
            );

            repository.saveAll(
                    List.of(ali,ayse)
            );
        };
    }
}
