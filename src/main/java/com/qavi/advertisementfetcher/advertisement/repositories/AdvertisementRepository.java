package com.qavi.advertisementfetcher.advertisement.repositories;

import com.qavi.advertisementfetcher.advertisement.entities.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

}
