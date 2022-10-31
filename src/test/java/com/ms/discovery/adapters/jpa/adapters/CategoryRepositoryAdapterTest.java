package com.ms.discovery.adapters.jpa.adapters;

import com.ms.discovery.adapters.jpa.repository.CategoryRepository;
import com.ms.discovery.adapters.rest.controllers.CategoryController;
import com.ms.discovery.application.ports.out.CategoryOutPort;
import com.ms.discovery.domain.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryRepositoryAdapterTest {

    /*@Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final CategoryOutPort categoryOutPort;

    @Test
    public void insertCategoryRepoTest() {
        Category categoryData = Category.builder()
                .name("테스트")
                .build();

        Integer categoryId = categoryOutPort.addCategory(categoryData);

        assertThat(categoryData.getId()).isSameAs(categoryId);
    }

    @Test
    void findAllCategoryRepoTest() {
        Category parent = Category.builder()
                .name("부모")
                .build();
        Category savedParent = categoryRepository.save(parent);
        Category child = Category.builder()
                .name("부모")
                .parent(savedParent)
                .build();
        Category savedChild = categoryRepository.save(child);

        List<Category> found = categoryRepository.findAll();

        assertThat(child).isSameAs(savedChild);
        assertThat(found.size()).isEqualTo(1);
    }*/
}