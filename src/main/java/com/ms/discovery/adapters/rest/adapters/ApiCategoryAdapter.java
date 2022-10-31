package com.ms.discovery.adapters.rest.adapters;

import com.ms.discovery.adapters.rest.dto.CategoryDto;
import com.ms.discovery.adapters.rest.mapper.CategoryDtoMapper;
import com.ms.discovery.adapters.rest.dto.SaveCategoryDto;
import com.ms.discovery.application.ports.in.CategoryInPort;
import com.ms.discovery.application.usecases.CategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ApiCategoryAdapter implements CategoryInPort {

    private final CategoryUseCase categoryUseCase;

    @Override
    public Integer addCategory(SaveCategoryDto saveCategoryDto) {
        return categoryUseCase.addCategory(CategoryDtoMapper.toEntity(saveCategoryDto));
    }

    @Override
    public void updateCategory(Integer categoryId, SaveCategoryDto saveCategoryDto) {
        categoryUseCase.updateCategory(CategoryDtoMapper.toEntity(categoryId, saveCategoryDto));
    }

    @Override
    public void removeCategory(Integer categoryId) {
        categoryUseCase.removeCategory(categoryId);
    }

    @Override
    public List<CategoryDto> getCategories() {
        return categoryUseCase.getCategories().stream().map(CategoryDto::of).collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryById(Integer CategoryId) {
        return CategoryDto.of(categoryUseCase.getCategoryById(CategoryId));
    }
}
