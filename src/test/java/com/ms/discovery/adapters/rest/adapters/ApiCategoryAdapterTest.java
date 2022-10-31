package com.ms.discovery.adapters.rest.adapters;

import com.ms.discovery.adapters.jpa.repository.CategoryRepository;
import com.ms.discovery.adapters.rest.dto.CategoryDto;
import com.ms.discovery.adapters.rest.dto.SaveCategoryDto;
import com.ms.discovery.application.ports.in.CategoryInPort;
import com.ms.discovery.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ApiCategoryAdapterTest {

    @Autowired
    private CategoryInPort categoryInPort;

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setUp() {
        categoryRepository.deleteAll();
    }

    @Test
    void addCategoryApiAdapterTest() {
        SaveCategoryDto category = SaveCategoryDto.builder()
                .name("상위")
                .build();

        Integer categoryId = categoryInPort.addCategory(category);
        Category saveCategory = categoryRepository.findById(categoryId).orElse(null);

        assertThat(saveCategory).isNotNull();
        assertThat(categoryId).isEqualTo(saveCategory.getId());
        assertThat(category.getName()).isEqualTo(saveCategory.getName());
    }

    @Test
    void updateCategoryApiAdapterTest() {
        String changeName = "하위";
        SaveCategoryDto category = SaveCategoryDto.builder()
                .name("상위")
                .build();
        Integer categoryId = categoryInPort.addCategory(category);
        SaveCategoryDto updateCategory = SaveCategoryDto.builder()
                .name(changeName)
                .build();

        categoryInPort.updateCategory(categoryId, updateCategory);
        Category saveCategory = categoryRepository.findById(categoryId).orElse(null);

        assertThat(saveCategory).isNotNull();
        assertThat(categoryId).isEqualTo(saveCategory.getId());
        assertThat(updateCategory.getName()).isEqualTo(saveCategory.getName());
    }

    @Test
    void deleteCategoryApiAdapterTest() {
        SaveCategoryDto category = SaveCategoryDto.builder()
                .name("상위")
                .build();
        Integer categoryId = categoryInPort.addCategory(category);
        categoryInPort.removeCategory(categoryId);

        Category saveCategory = categoryRepository.findById(categoryId).orElse(null);

        assertThat(saveCategory).isNull();
    }

    @Test
    void getCategoryApiAdapterTest() {
        SaveCategoryDto category = SaveCategoryDto.builder()
                .name("상위")
                .build();
        Integer categoryId = categoryInPort.addCategory(category);

        CategoryDto saveCategory = categoryInPort.getCategoryById(categoryId);

        assertThat(saveCategory).isNotNull();
        assertThat(categoryId).isEqualTo(saveCategory.getId());
        assertThat(category.getName()).isEqualTo(saveCategory.getName());
    }

    @Test
    void getAllCategoryApiAdapterTest() {
        SaveCategoryDto category = SaveCategoryDto.builder()
                .name("상위")
                .build();
        categoryInPort.addCategory(category);

        List<CategoryDto> categories = categoryInPort.getCategories();

        assertThat(categories.size()).isEqualTo(1);
    }
}