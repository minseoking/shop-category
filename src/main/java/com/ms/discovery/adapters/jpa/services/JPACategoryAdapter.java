package com.ms.discovery.adapters.jpa.services;

import com.ms.discovery.adapters.jpa.entities.CategoryJpaMapper;
import com.ms.discovery.adapters.jpa.entities.CategoryData;
import com.ms.discovery.adapters.jpa.repository.CategoryRepository;
import com.ms.discovery.application.ports.out.CategoryOutPort;
import com.ms.discovery.domain.Category;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JPACategoryAdapter implements CategoryOutPort {

    @NonNull
    private final CategoryRepository categoryRepository;

    @Override
    public int addCategory(Category category) {
        CategoryData categoryData = CategoryJpaMapper.toJpaDto(category);
        CategoryData userSaved = categoryRepository.save(categoryData);

        return userSaved.getId();
    }

    @Override
    public void removeCategory(Category Category) {

    }

    @Override
    public List<Category> getCategories() {
        return null;
    }

    @Override
    public Category getCategoryById(Integer CategoryId) {
        return null;
    }
}
