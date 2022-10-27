package com.ms.discovery.application.usecases;

import com.ms.discovery.domain.Category;

import java.util.List;

public interface CategoryUseCase {
    int addCategory(Category category);

    void removeCategory(Category Category);

    List<Category> getCategories();

    Category getCategoryById(Integer CategoryId);
}
