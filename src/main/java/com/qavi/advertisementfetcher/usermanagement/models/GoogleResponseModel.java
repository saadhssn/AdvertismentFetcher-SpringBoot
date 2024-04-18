package com.qavi.advertisementfetcher.usermanagement.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoogleResponseModel {
    private String azp;
    private String aud;
    private String sub;
    private String scope;
    private String exp;
    private String expires_in;
    private String email;
    private Boolean email_verified;
    private String access_type;
}