package com.qavi.advertisementfetcher.usermanagement.repositories;

import com.qavi.advertisementfetcher.usermanagement.entities.user.ProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileImageRepository extends JpaRepository<ProfileImage,Long> {
}
