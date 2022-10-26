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
@Table
@ToString
public class Advert {

    @Id
    @SequenceGenerator(
            name = "adverts_sequence",
            sequenceName = "adverts_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "adverts_sequence"
    )


    private int id;
    private String bloodGroup;
    private String rh;
    private String adress;
    private String messages;
    private String phone;
}
