package com.qavi.advertisementfetcher.usermanagement.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.qavi.advertisementfetcher.usermanagement.entities.user.User;
import com.qavi.advertisementfetcher.usermanagement.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import static com.qavi.advertisementfetcher.AdvertisementFetcherApplication.loginExpiryTimeMinutes;
import static com.qavi.advertisementfetcher.AdvertisementFetcherApplication.secretJWT;

@Component
public class JWTGenerator {
    @Autowired
    UserService userService;
    private final HttpServletRequest request;



    public JWTGenerator(HttpServletRequest request) {
        this.request = request;
    }

    public String generateJWTToken(User user){
        Algorithm algorithm = Algorithm.HMAC256(secretJWT.getBytes());
        CustomUserDetails customUserDetails=userService.loadUserByUsername(user.getEmail());
        String accessToken = JWT.create()
                .withSubject(String.valueOf(user.getId()))
                .withExpiresAt(java.sql.Timestamp.valueOf(LocalDateTime.now().plusMinutes(loginExpiryTimeMinutes)))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles",customUserDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);
        return accessToken;
    }
}
