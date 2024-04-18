package com.qavi.advertisementfetcher.usermanagement.controllers.otp;

import com.qavi.advertisementfetcher.usermanagement.entities.otp.Otp;
import com.qavi.advertisementfetcher.usermanagement.services.otp.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/otp")
public class OtpController {
    @Autowired
    private OtpService otpService;


    //GetAll Otp controller
    @ResponseBody
    @GetMapping
    public ResponseEntity<List<Otp>> getAllOtp() {
        List<Otp> allOtp = otpService.getAllOtp();
        return new ResponseEntity<>(allOtp, HttpStatus.OK);
    }

    //Get Otp By id
    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity<Otp> getOtpById(@PathVariable Long id) {
        Otp otpById = otpService.getOtpById(id);
        return new ResponseEntity<>(otpById, HttpStatus.OK);
    }

    //Create a Otp
    @ResponseBody
    @PostMapping("/add-otp")
    public ResponseEntity<Otp> createOtp(@RequestBody Otp otp) {
        Otp createdOtp = otpService.createOtp(otp);
        return new ResponseEntity<>(createdOtp, HttpStatus.CREATED);
    }

    //update Otp
    @ResponseBody
    @PutMapping("/{id}")
    public ResponseEntity<Otp> updateRole(@RequestBody Otp otp, @PathVariable Long id) {
        Otp updateOtp = otpService.UpdateOtp(otp, id);
        return new ResponseEntity<>(updateOtp, HttpStatus.OK);
    }

    //Delete Otp
    @ResponseBody
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOtp(@PathVariable Long id) {
        otpService.deleteOtp(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
