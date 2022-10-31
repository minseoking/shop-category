package com.ms.discovery.application.services;

import com.ms.discovery.application.ports.out.CategoryOutPort;
import com.ms.discovery.application.usecases.CategoryUseCase;
import com.ms.discovery.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements CategoryUseCase {

    private final CategoryOutPort categoryOutPort;

    @Override
    @Transactional
    public Integer addCategory(Category category) {
        if (category.getParent() != null) {
            Category parent =  categoryOutPort.getCategoryById(category.getParent().getId());
            category = Category.builder()
                .name(category.getName())
                .parent(parent)
                .build();
        }
        return categoryOutPort.addCategory(category);
    }

    @Override
    @Transactional
    public Integer updateCategory(Category category) {
        return categoryOutPort.updateCategory(category);
    }

    @Override
    @Transactional
    public void removeCategory(Integer categoryId) {
        categoryOutPort.removeCategory(categoryId);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Category> getCategories() {
        return categoryOutPort.getCategories();
    }

    @Override
    @Transactional(readOnly=true)
    public Category getCategoryById(Integer categoryId) {
        return categoryOutPort.getCategoryById(categoryId);
    }
}
