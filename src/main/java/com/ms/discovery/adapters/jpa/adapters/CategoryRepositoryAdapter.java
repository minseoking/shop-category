package com.ms.discovery.adapters.jpa.adapters;

import com.ms.discovery.adapters.jpa.repository.CategoryRepository;
import com.ms.discovery.application.ports.out.CategoryOutPort;
import com.ms.discovery.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryRepositoryAdapter implements CategoryOutPort {

    private final CategoryRepository categoryRepository;

    @Override
    public Integer addCategory(Category category) {
        Category categorySaved = categoryRepository.save(category);
        return categorySaved.getId();
    }

    @Override
    public Integer updateCategory(Category category) {
        Category categorySaved = categoryRepository.save(category);
        return categorySaved.getId();
    }

    @Override
    public void removeCategory(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }
}
