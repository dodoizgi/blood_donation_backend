package com.example.blood_donation.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticaitonRequest {

    private String email;
    private String password;

}
