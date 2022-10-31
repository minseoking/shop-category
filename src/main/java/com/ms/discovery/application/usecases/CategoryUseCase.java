package com.ms.discovery.application.usecases;

import com.ms.discovery.domain.Category;

import java.util.List;

public interface CategoryUseCase {
    Integer addCategory(Category category);

    Integer updateCategory(Category category);

    void removeCategory(Integer categoryId);

    List<Category> getCategories();

    Category getCategoryById(Integer CategoryId);
}
