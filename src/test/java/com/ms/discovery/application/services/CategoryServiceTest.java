package com.ms.discovery.application.services;

import com.ms.discovery.adapters.jpa.repository.CategoryRepository;
import com.ms.discovery.application.usecases.CategoryUseCase;
import com.ms.discovery.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryUseCase categoryUseCase;

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setUp() {
        categoryRepository.deleteAll();
    }

    @Test
    void addCategoryServiceTest() {
        Category category = Category.builder()
                .name("상위")
                .build();

        Integer categoryId = categoryUseCase.addCategory(category);
        Category saveCategory = categoryRepository.findById(categoryId).orElse(null);

        assertThat(saveCategory).isNotNull();
        assertThat(categoryId).isEqualTo(saveCategory.getId());
        assertThat(category.getName()).isEqualTo(saveCategory.getName());
    }

    @Test
    void updateCategoryServiceTest() {
        String changeName = "하위";
        Category category = Category.builder()
                .name("상위")
                .build();
        Integer categoryId = categoryUseCase.addCategory(category);
        Category updateCategory = Category.builder()
                .id(categoryId)
                .name(changeName)
                .build();

        categoryUseCase.updateCategory(updateCategory);
        Category saveCategory = categoryRepository.findById(categoryId).orElse(null);

        assertThat(saveCategory).isNotNull();
        assertThat(categoryId).isEqualTo(saveCategory.getId());
        assertThat(updateCategory.getName()).isEqualTo(saveCategory.getName());
    }

    @Test
    void deleteCategoryServiceTest() {
        Category category = Category.builder()
                .name("상위")
                .build();
        Integer categoryId = categoryUseCase.addCategory(category);
        categoryUseCase.removeCategory(categoryId);

        Category saveCategory = categoryRepository.findById(categoryId).orElse(null);

        assertThat(saveCategory).isNull();
    }

    @Test
    void getCategoryServiceTest() {
        Category category = Category.builder()
                .name("상위")
                .build();
        Integer categoryId = categoryUseCase.addCategory(category);

        Category saveCategory = categoryUseCase.getCategoryById(categoryId);

        assertThat(saveCategory).isNotNull();
        assertThat(categoryId).isEqualTo(saveCategory.getId());
        assertThat(category.getName()).isEqualTo(saveCategory.getName());
    }

    @Test
    void getAllCategoryServiceTest() {
        Category category = Category.builder()
                .name("상위")
                .build();
        categoryUseCase.addCategory(category);

        List<Category> categories = categoryUseCase.getCategories();

        assertThat(categories.size()).isEqualTo(1);
    }
}