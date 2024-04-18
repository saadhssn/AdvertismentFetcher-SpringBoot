package com.qavi.advertisementfetcher.usermanagement.repositories;

import com.qavi.advertisementfetcher.usermanagement.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query(value = "Select * from users where email=?1", nativeQuery = true)
    User getUser(String email);

    @Query(value = "select * from users where email=?1 and auth_type=?2", nativeQuery = true)
    Optional<User> findByEmail(String email, String authType);

    Optional<User> findById(Long id);
}

