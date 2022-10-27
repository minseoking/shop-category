package com.ms.discovery.adapters.jpa.entities;

import com.ms.discovery.domain.Category;

public interface CategoryJpaMapper {

    static CategoryData toJpaDto(Category user) {
        return CategoryData.builder()
                .build();
    }


    static Category toDomain(CategoryData userData) {
        return Category.builder()
                .build();
    }
}