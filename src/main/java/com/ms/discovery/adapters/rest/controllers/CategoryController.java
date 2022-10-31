package com.ms.discovery.adapters.rest.controllers;

import com.ms.discovery.adapters.rest.dto.CategoryDto;
import com.ms.discovery.adapters.rest.dto.SaveCategoryDto;
import com.ms.discovery.application.ports.in.CategoryInPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "categories", description = "카테고리 API")
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryInPort categoryInPort;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "카테고리 등록")
    public void addCategory(@RequestBody @Valid SaveCategoryDto categoryDto) {
        categoryInPort.addCategory(categoryDto);
    }

    @PutMapping("/{category_id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "카테고리 수정")
    public void updateCategory(@PathVariable("category_id") int categoryId,
                                               @RequestBody @Valid SaveCategoryDto categoryDto) {
        categoryInPort.updateCategory(categoryId, categoryDto);
    }

    @DeleteMapping("/{category_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "카테고리 삭제")
    public void deleteCategoryById(@PathVariable("category_id") Integer categoryId) {
        categoryInPort.removeCategory(categoryId);
    }

    @GetMapping("/{category_id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "카테고리 1건 조회")
    public CategoryDto getCategoriesById(@PathVariable("category_id") Integer categoryId) {
        return categoryInPort.getCategoryById(categoryId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "모든 카테고리 조회")
    public List<CategoryDto> getAllCategories() {
        return categoryInPort.getCategories();
    }
}
