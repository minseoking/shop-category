package com.ms.discovery.application.ports.out;


import com.ms.discovery.domain.Category;

import java.util.List;

public interface CategoryOutPort {
    int addCategory(Category category);

    void removeCategory(Category Category);

    List<Category> getCategories();

    Category getCategoryById(Integer CategoryId);
}
