package com.ms.discovery.adapters.jpa.repository;

import com.ms.discovery.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    /*@Query(value = "SELECT distinct parent" +
            " FROM Category parent" +
            " LEFT JOIN Category.children child" +
            " WHERE parent.parent is null ")*/
//    @Query("select c from Category c where c.parent is NULL")
    @Query("select distinct c from Category c join fetch c.children WHERE c.parent is null")
    List<Category> findAll();
}
