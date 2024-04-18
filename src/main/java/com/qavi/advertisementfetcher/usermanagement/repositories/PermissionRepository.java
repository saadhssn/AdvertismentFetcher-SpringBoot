package com.qavi.advertisementfetcher.usermanagement.repositories;

import com.qavi.advertisementfetcher.usermanagement.entities.permission.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Permission findByName(String name);
}
