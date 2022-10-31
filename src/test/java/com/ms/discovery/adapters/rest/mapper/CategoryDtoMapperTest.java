package com.ms.discovery.adapters.rest.mapper;

import com.ms.discovery.adapters.rest.dto.SaveCategoryDto;
import com.ms.discovery.domain.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CategoryDtoMapperTest {

    @Test
    public void toEntityTest() {
        SaveCategoryDto saveCategoryDto = SaveCategoryDto.builder()
                .parentId(1)
                .name("상의")
                .build();
        Category category = CategoryDtoMapper.toEntity(saveCategoryDto);

        assertThat(saveCategoryDto.getName()).isEqualTo(category.getName());
        assertThat(saveCategoryDto.getParentId()).isEqualTo(category.getParent().getId());
    }
}