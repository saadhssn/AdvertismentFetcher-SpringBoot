package com.qavi.advertisementfetcher.usermanagement.entities.otp;

import com.qavi.advertisementfetcher.usermanagement.entities.user.User;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Otp{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    private String token;
    private String tokenType;
    @ManyToOne
    private User user;

}
