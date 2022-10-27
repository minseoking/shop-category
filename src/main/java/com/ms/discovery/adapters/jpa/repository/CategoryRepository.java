package com.ms.discovery.adapters.jpa.repository;

import com.ms.discovery.adapters.jpa.entities.CategoryData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryData, Integer> {
}
