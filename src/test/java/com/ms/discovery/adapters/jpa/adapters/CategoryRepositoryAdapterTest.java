package com.ms.discovery.adapters.jpa.adapters;

import com.ms.discovery.adapters.jpa.repository.CategoryRepository;
import com.ms.discovery.application.ports.out.CategoryOutPort;
import com.ms.discovery.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CategoryRepositoryAdapterTest {

    @Autowired
    private CategoryOutPort categoryOutPort;

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setUp() {
        categoryRepository.deleteAll();
    }

    @Test
    void addCategoryRepoAdapterTest() {
        Category category = Category.builder()
                .name("부모")
                .build();

        Integer categoryId = categoryOutPort.addCategory(category);
        Category saveCategory = categoryRepository.findById(categoryId).orElse(null);

        assertThat(saveCategory).isNotNull();
        assertThat(categoryId).isEqualTo(saveCategory.getId());
        assertThat(category.getName()).isEqualTo(saveCategory.getName());
    }

    @Test
    void updateCategoryRepoAdapterTest() {
        String changeName = "자식";
        Category category = Category.builder()
                .name("부모")
                .build();
        Integer categoryId = categoryOutPort.addCategory(category);
        Category updateCategory = Category.builder()
                .id(categoryId)
                .name(changeName)
                .build();

        categoryOutPort.updateCategory(updateCategory);
        Category saveCategory = categoryRepository.findById(categoryId).orElse(null);

        assertThat(saveCategory).isNotNull();
        assertThat(categoryId).isEqualTo(saveCategory.getId());
        assertThat(updateCategory.getName()).isEqualTo(saveCategory.getName());
    }

    @Test
    void deleteCategoryRepoAdapterTest() {
        Category category = Category.builder()
                .name("부모")
                .build();
        Integer categoryId = categoryOutPort.addCategory(category);
        categoryOutPort.removeCategory(categoryId);

        Category saveCategory = categoryRepository.findById(categoryId).orElse(null);

        assertThat(saveCategory).isNull();
    }

    @Test
    void getCategoryRepoAdapterTest() {
        Category category = Category.builder()
                .name("부모")
                .build();
        Integer categoryId = categoryOutPort.addCategory(category);

        Category saveCategory = categoryOutPort.getCategoryById(categoryId);

        assertThat(saveCategory).isNotNull();
        assertThat(categoryId).isEqualTo(saveCategory.getId());
        assertThat(category.getName()).isEqualTo(saveCategory.getName());
    }

    @Test
    void getAllCategoryRepoAdapterTest() {
        Category category = Category.builder()
                .name("부모")
                .build();
        categoryOutPort.addCategory(category);

        List<Category> categories = categoryOutPort.getCategories();

        assertThat(categories.size()).isEqualTo(1);
    }
}