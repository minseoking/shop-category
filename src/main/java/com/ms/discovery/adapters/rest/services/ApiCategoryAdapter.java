package com.ms.discovery.adapters.rest.services;

import com.ms.discovery.adapters.rest.dto.CategoryDto;
import com.ms.discovery.adapters.rest.dto.SaveCategoryDto;
import com.ms.discovery.adapters.rest.dto.CategoryDtoMapper;
import com.ms.discovery.application.ports.in.CategoryInPort;
import com.ms.discovery.application.usecases.CategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiCategoryAdapter implements CategoryInPort {

    @Autowired
    private final CategoryUseCase categoryUseCase;

    @Override
    public int addCategory(SaveCategoryDto saveCategoryDto) {
        return categoryUseCase.addCategory(CategoryDtoMapper.toDto(saveCategoryDto));
    }

    @Override
    public int removeCategory(SaveCategoryDto categoryDto) {

        return 0;
    }

    @Override
    public List<CategoryDto> getCategories() {
        return null;
    }

    @Override
    public CategoryDto getCategoryById(Integer CategoryId) {
        return null;
    }
}
