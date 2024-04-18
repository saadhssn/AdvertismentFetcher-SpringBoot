package com.qavi.advertisementfetcher.usermanagement.services.user;

import com.qavi.advertisementfetcher.usermanagement.constants.UserConstants;
import com.qavi.advertisementfetcher.usermanagement.entities.user.User;
import com.qavi.advertisementfetcher.usermanagement.models.GoogleResponseModel;
import com.qavi.advertisementfetcher.usermanagement.repositories.UserRepository;
import com.qavi.advertisementfetcher.usermanagement.utils.JWTGenerator;
import com.qavi.advertisementfetcher.globalexceptions.InvalidTokenException;
import com.qavi.advertisementfetcher.globalexceptions.RecordAlreadyExists;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Optional;

@Service
public class GoogleSignInService {

    private final OkHttpClient apiClient;
    private final UserService userService;
    private final JWTGenerator jwtGenerator;

    private final UserRepository appUserRepository;


    public GoogleSignInService(UserService userService, JWTGenerator jwtGenerator, UserRepository appUserRepository) {

        this.userService = userService;
        this.jwtGenerator = jwtGenerator;
        this.appUserRepository = appUserRepository;
        this.apiClient = new OkHttpClient.Builder()
                .build();
    }


    public String googleSignIn(String googleIdToken) throws GeneralSecurityException, IOException {

        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://oauth2.googleapis.com/tokeninfo?access_token=" + googleIdToken;
        GoogleResponseModel googleResponse;
        try{
            googleResponse = restTemplate.getForObject(uri, GoogleResponseModel.class);
        }
        catch(HttpStatusCodeException e){
            throw new InvalidTokenException("Google Token Invalid");
        }

        String email = googleResponse.getEmail();
        String firstname = email.substring(0, email.indexOf('@'));


        Optional<User> appUserLocal = userService.findUserByEmail(email, UserConstants.LOCAL);
        Optional<User> appUserApple = userService.findUserByEmail(email, UserConstants.APPLE);
        Optional<User> appUserFacebook = userService.findUserByEmail(email, UserConstants.FACEBOOK);

        if(appUserLocal.isPresent() || appUserApple.isPresent() || appUserFacebook.isPresent()){
            throw new RecordAlreadyExists("Account already exists");
        }

        Optional<User> appUser = userService.findUserByEmail(email, UserConstants.GOOGLE);
        String accessToken = "";
        if(appUser.isPresent()) {

            accessToken = jwtGenerator.generateJWTToken(appUser.get());
            return accessToken;
        } else {
            //create and save  new technician in db
            User user=new User();
            user.setFirstName(firstname);
            user.setLastName("");
            user.setEnabled(true);
            user.setEmail(email);
            user.setAuthType(UserConstants.GOOGLE);
            user.setEmailNotificationEnabled(false);
            appUserRepository.save(user);
            accessToken = jwtGenerator.generateJWTToken(user);

            return accessToken;
        }
    }
}
