package com.ms.discovery.adapters.jpa.repository;

import com.ms.discovery.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("select distinct c from Category c left join fetch c.children")
    List<Category> findAll();
}
