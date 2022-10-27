package com.ms.discovery.application.services;

import com.ms.discovery.application.usecases.CategoryUseCase;
import com.ms.discovery.domain.Category;
import com.ms.discovery.application.ports.out.CategoryOutPort;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceAdapter implements CategoryUseCase {

    @NonNull
    private final CategoryOutPort categoryOutPort;

    @Override
    public int addCategory(Category category) {
        return categoryOutPort.addCategory(category);
    }

    @Override
    public void removeCategory(Category category) {
        categoryOutPort.removeCategory(category);
    }

    @Override
    public List<Category> getCategories() {
        return categoryOutPort.getCategories();
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        return categoryOutPort.getCategoryById(categoryId);
    }
}
