package com.ms.discovery.application.ports.in;


import com.ms.discovery.adapters.rest.dto.CategoryDto;
import com.ms.discovery.adapters.rest.dto.SaveCategoryDto;

import java.util.List;

public interface CategoryInPort {
    Integer addCategory(SaveCategoryDto category);

    void updateCategory(Integer categoryId, SaveCategoryDto category);

    void removeCategory(Integer categoryId);

    List<CategoryDto> getCategories();

    CategoryDto getCategoryById(Integer categoryId);
}
