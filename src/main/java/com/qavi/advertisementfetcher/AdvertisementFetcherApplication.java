package com.qavi.advertisementfetcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdvertisementFetcherApplication {

	public static final String secretJWT = "ocrapplicationlkajjqieojqiojeksmndvjasfjhasdifjiwef";
	public static final Long loginExpiryTimeMinutes = 120L;
    public static void main(String[] args) {


        SpringApplication.run(AdvertisementFetcherApplication.class, args);
    }

}
