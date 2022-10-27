package com.ms.discovery.adapters.jpa.repository;

import com.ms.discovery.adapters.jpa.entities.CategoryData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setUp() {
        categoryRepository.deleteAll();
    }

    @Test
    @DisplayName("카테고리 생성 테스트")
    public void insertCategoryTest() {
        CategoryData categoryData = CategoryData.builder()
            .build();
        categoryData = categoryRepository.save(categoryData);

        Optional<CategoryData> found = categoryRepository.findById(categoryData.getId());

        assertThat(found.isPresent()).isTrue();
    }
}