package com.ms.discovery.application.services;

import com.ms.discovery.application.ports.out.CategoryOutPort;
import com.ms.discovery.application.usecases.CategoryUseCase;
import com.ms.discovery.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoryService implements CategoryUseCase {

    private final CategoryOutPort categoryOutPort;

    @Override
    @Transactional
    public Integer addCategory(Category category) {
        if (category.getParent() != null) {
            Category parent = categoryOutPort.getCategoryById(category.getParent().getId());
            verifyCategory(category);

            category.updateCategory(category.getName(), parent);
        }

        return categoryOutPort.addCategory(category);
    }

    @Override
    @Transactional
    public Integer updateCategory(Integer categoryId, Category category) {
        Category foundCategory = categoryOutPort.getCategoryById(categoryId);
        verifyCategory(category);

        foundCategory.updateCategory(category.getName(), category.getParent());

        return categoryOutPort.updateCategory(foundCategory);
    }

    @Override
    @Transactional
    public void removeCategory(Integer categoryId) {
        categoryOutPort.removeCategory(categoryId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> getAllCategories() {
        return categoryOutPort.getCategories();
    }

    @Override
    @Transactional(readOnly = true)
    public Category getCategoryById(Integer categoryId) {
        Category category = categoryOutPort.getCategoryById(categoryId);
        verifyCategory(category);

        return category;
    }

    private void verifyCategory(Category category) {
        if (category == null) {
            throw new NoSuchElementException();
        }
    }
}
