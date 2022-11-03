package com.example.blood_donation.domain;

import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EnableAutoConfiguration
@Entity
@Table(name = "ADVERT")
@ToString
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bloodGroup;
    private String rh;
    private String adress;
    private String messages;
    private String phone;
    private int userId;
}
