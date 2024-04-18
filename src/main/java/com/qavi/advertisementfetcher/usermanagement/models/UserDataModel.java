package com.qavi.advertisementfetcher.usermanagement.models;

import com.qavi.advertisementfetcher.usermanagement.entities.role.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDataModel {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<Role> roles;
    private String authType;
    private boolean enabled;
    private LocalDateTime lastLoginAt;
//    private Set<Business> customerAt;

}
