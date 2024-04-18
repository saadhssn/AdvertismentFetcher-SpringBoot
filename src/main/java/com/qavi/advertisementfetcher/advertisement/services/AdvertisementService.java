package com.qavi.advertisementfetcher.advertisement.services;

import com.qavi.advertisementfetcher.advertisement.entities.Advertisement;

import com.qavi.advertisementfetcher.advertisement.repositories.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;

    //Get All Advertisements
    public List<Advertisement> getAllAdvertisements() {
        List<Advertisement> advertisements = advertisementRepository.findAll().stream().collect(Collectors.toList());
        return advertisements;
    }

    //Get One Advertisement
    public Advertisement getAdvertisement(Long id) {
        return advertisementRepository.findById(id).get();
    }

    //update Advertisement
    public Advertisement updateAdvertisement(Advertisement advertisement, Long id) {
        Advertisement existingAD = advertisementRepository.findById(id).get();
        if (existingAD != null) {
            existingAD.setTitle(advertisement.getTitle());
            existingAD.setLocation(advertisement.getLocation());
            existingAD.setDescription(advertisement.getDescription());
            existingAD.setCategory(advertisement.getCategory());
            existingAD.setUser(advertisement.getUser());
            return advertisementRepository.save(existingAD);
        } else {
            return null;
        }
    }

    //Delete Advertisement
    public Boolean deleteAdvertisement(Long id) {
        try {
            advertisementRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    //Post Advertisement
    public Advertisement createAdvertisement(Advertisement advertisement){
        return advertisementRepository.save(advertisement);
    }
}
