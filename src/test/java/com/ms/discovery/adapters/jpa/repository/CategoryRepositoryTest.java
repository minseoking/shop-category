package com.ms.discovery.adapters.jpa.repository;

import com.ms.discovery.domain.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void findAllCategoryRepoTest() {
        Category parent = Category.builder()
                .name("상위")
                .build();
        Category savedParent = categoryRepository.save(parent);
        Category child = Category.builder()
                .name("하위")
                .parent(savedParent)
                .build();
        Category savedChild = categoryRepository.save(child);

        List<Category> found = categoryRepository.findAll();

        assertThat(parent).isSameAs(savedParent);
        assertThat(child).isSameAs(savedChild);
        assertThat(found.size()).isEqualTo(1);
    }
}