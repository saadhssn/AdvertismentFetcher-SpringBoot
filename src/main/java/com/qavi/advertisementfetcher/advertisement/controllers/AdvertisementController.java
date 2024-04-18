package com.qavi.advertisementfetcher.advertisement.controllers;

import com.qavi.advertisementfetcher.advertisement.entities.Advertisement;

import com.qavi.advertisementfetcher.advertisement.services.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/advertisement")
public class AdvertisementController {
    @Autowired
    private  AdvertisementService advertisementService;



    @PostMapping("/add-advertisement")
    public ResponseEntity<Advertisement> addAdvertisement(@RequestBody Advertisement advertisement) {
        Advertisement createdAdvertisement = advertisementService.createAdvertisement(advertisement);
        return new ResponseEntity<>(createdAdvertisement, HttpStatus.CREATED);
    }



    //Get all advertisements
    @GetMapping
    public ResponseEntity<List<Advertisement>> getAllAdvertisements() {
        List<Advertisement> advertisements = advertisementService.getAllAdvertisements();
        return new ResponseEntity<List<Advertisement>>(advertisements, HttpStatus.OK);
    }

    //Get advertisement by id
    @GetMapping("/{id}")
    public ResponseEntity<Advertisement> getAdvertisement(@PathVariable Long id) {
        Advertisement advertisement = advertisementService.getAdvertisement(id);
        return new ResponseEntity<Advertisement>(advertisement, HttpStatus.OK);
    }

    //update Controller.
    @PutMapping("/{id}")
    public ResponseEntity<Advertisement> updateAdvertisement(@RequestBody Advertisement advertisement, @PathVariable long id) {
        advertisementService.updateAdvertisement(advertisement, id);
        return new ResponseEntity<Advertisement>(advertisement, HttpStatus.OK);
    }

    // Delete Advertisement

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAdvertisement(@PathVariable Long id) {
        Boolean deletedAdvertisement = advertisementService.deleteAdvertisement(id);
        return new ResponseEntity<>(deletedAdvertisement, HttpStatus.OK);
    }
}

