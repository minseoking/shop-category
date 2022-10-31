package com.ms.discovery.adapters.rest.mapper;

import com.ms.discovery.adapters.rest.dto.SaveCategoryDto;
import com.ms.discovery.domain.Category;

public interface CategoryDtoMapper {
    static Category toEntity(SaveCategoryDto category) {
        return Category.builder()
            .name(category.getName())
            .parent(category.getParentId() == null ?
                null
                : Category.builder().id(category.getParentId()).build())
            .build();
    }

    static Category toEntity(Integer categoryId, SaveCategoryDto category) {
        return Category.builder()
            .id(categoryId)
            .name(category.getName())
            .parent(category.getParentId() == null ?
                null
                : Category.builder().id(category.getParentId()).build())
            .build();
    }
}
