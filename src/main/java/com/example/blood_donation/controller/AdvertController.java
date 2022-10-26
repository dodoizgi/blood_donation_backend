package com.example.blood_donation.controller;

import com.example.blood_donation.domain.Advert;
import com.example.blood_donation.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adverts")
public class AdvertController {

    @Autowired
    private final AdvertService advertService;

    @Autowired
    public AdvertController(AdvertService advertservice) {
        this.advertService = advertservice;
    }

    @GetMapping
    public List<Advert> getAdverts() {
        return advertService.getAdverts();
    }

    @PostMapping
    public void registerNewAdvert(@RequestBody Advert advert) {advertService.addNewAdvert(advert);}

    @DeleteMapping(path = {"{advertID}"})
    public void deleteAdvert(@PathVariable("advertID") int advertID) {
        advertService.deleteAdvert(advertID);
    }

    @PutMapping(path = "{advertId}")
    public void updateAdvert(
            @PathVariable("advertId") int advertId,
            @RequestParam(required = false) String bloodGroup,
            @RequestParam(required = false) String rh) {
        advertService.updateAdvert(advertId, bloodGroup, rh);
    }
}
