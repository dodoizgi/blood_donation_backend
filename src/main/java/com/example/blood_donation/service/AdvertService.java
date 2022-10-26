package com.example.blood_donation.service;

import com.example.blood_donation.domain.Advert;
import com.example.blood_donation.repository.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdvertService {

    private final AdvertRepository advertsrepository;

    @Autowired
    public AdvertService(AdvertRepository advertrepository) {
        this.advertsrepository = advertrepository;
    }
    public List<Advert> getAdverts() {
        return advertsrepository.findAll();
    }

    public void addNewAdvert(Advert advert) {
        Optional<Advert> advertOptinal = advertsrepository.findAdvertByBloodGroup(advert.getBloodGroup());
        if (advertOptinal.isPresent()) {
            throw new IllegalStateException("blood group taken");
        }
        advertsrepository.save(advert);
    }

    public void deleteAdvert(int advertId) {
        boolean exists = advertsrepository.existsById(advertId);
        if (!exists) {
            throw new IllegalStateException(
                    "advert with id " + advertId + " does not exits"
            );
        }
        advertsrepository.deleteById(advertId);
    }

    @Transactional
    public void updateAdvert(int advertId, String bloodGroup, String rh) {
        Advert advert = advertsrepository.findById(advertId).orElseThrow(() ->
                new IllegalStateException(
                "advert with id " + advertId + " does not exists"
        ));

        if (bloodGroup != null &&
                !Objects.equals(advert.getBloodGroup(),bloodGroup)) {
            advert.setBloodGroup(bloodGroup);
        }

        if (rh != null &&
                !Objects.equals(advert.getRh(),rh)) {
            advert.setRh(rh);
        }

    }
}
