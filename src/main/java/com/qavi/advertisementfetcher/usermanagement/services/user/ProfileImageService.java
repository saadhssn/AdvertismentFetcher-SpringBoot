package com.qavi.advertisementfetcher.usermanagement.services.user;

import com.qavi.advertisementfetcher.usermanagement.entities.user.ProfileImage;
import com.qavi.advertisementfetcher.usermanagement.entities.user.User;
import com.qavi.advertisementfetcher.usermanagement.repositories.ProfileImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProfileImageService {
    @Autowired
    ProfileImageRepository profileRepository;

    @Autowired
    UserService userService;
    @Value("${spring.application.baseUrl}")
    private String baseUrl;



    public Long saveFileKey(String uploadedFileKey) {
        ProfileImage image = ProfileImage.builder().key(uploadedFileKey).build();
        ProfileImage savedImg = profileRepository.save(image);
        return savedImg.getId();
    }
    public Map<String,Object> getProfileImgData(Long userId){

            Map<String,Object> data = new HashMap<>();

            User user = userService.getUser(userId);

            if(user.getProfileImage()==null){
                data.put("id",null);
                data.put("url",null);
            }
            else{
                data.put("id",user.getProfileImage().getId());
                data.put("url",baseUrl + "/api/file/" + user.getProfileImage().getKey());
            }

            return data;
    }
}
