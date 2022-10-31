package com.ms.discovery.application.ports.out;


import com.ms.discovery.domain.Category;

import java.util.List;

public interface CategoryOutPort {
    Integer addCategory(Category category);

    Integer updateCategory(Category category);

    void removeCategory(Integer categoryId);

    List<Category> getCategories();

    Category getCategoryById(Integer categoryId);
}
