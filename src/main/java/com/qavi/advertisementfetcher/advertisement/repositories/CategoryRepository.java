package com.qavi.advertisementfetcher.advertisement.repositories;

import com.qavi.advertisementfetcher.advertisement.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
