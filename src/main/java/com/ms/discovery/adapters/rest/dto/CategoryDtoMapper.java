package com.ms.discovery.adapters.rest.dto;

import com.ms.discovery.domain.Category;

public interface CategoryDtoMapper {
    static Category toDto(SaveCategoryDto category) {
        return Category.builder()
                .build();
    }
}
