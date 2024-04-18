package com.qavi.advertisementfetcher.usermanagement.services.otp;

import com.qavi.advertisementfetcher.usermanagement.entities.otp.Otp;
import com.qavi.advertisementfetcher.usermanagement.repositories.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtpService {
    @Autowired
    private OtpRepository otpRepository;

    //Get All OTP
    public List<Otp> getAllOtp() {
        return otpRepository.findAll();
    }

    //Get OTP By ID
    public Otp getOtpById(Long id) {
        return otpRepository.findById(id).get();
    }

    //Create OTP
    public Otp createOtp(Otp otp) {
        return otpRepository.save(otp);
    }

    //Update OTP
    public Otp UpdateOtp(Otp otp, Long id) {
        Otp existingOtp = otpRepository.findById(id).get();
        if (existingOtp != null) {
            existingOtp.setCreatedAt(otp.getCreatedAt());
            existingOtp.setExpiresAt(otp.getExpiresAt());
            existingOtp.setToken(otp.getToken());
            existingOtp.setTokenType(otp.getTokenType());
            existingOtp.setUser(otp.getUser());

            return otpRepository.save(existingOtp);
        } else {
            return null;
        }
    }

    //Delete Otp
    public void deleteOtp(Long id) {
        Otp otp = otpRepository.findById(id).get();
        if (otp != null) {
            otpRepository.delete(otp);
        }
    }
}
