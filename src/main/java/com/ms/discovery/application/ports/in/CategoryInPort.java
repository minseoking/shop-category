package com.ms.discovery.application.ports.in;


import com.ms.discovery.adapters.rest.dto.CategoryDto;
import com.ms.discovery.adapters.rest.dto.SaveCategoryDto;

import java.util.List;

public interface CategoryInPort {
    int addCategory(SaveCategoryDto category);

    int removeCategory(SaveCategoryDto Category);

    List<CategoryDto> getCategories();

    CategoryDto getCategoryById(Integer CategoryId);
}
