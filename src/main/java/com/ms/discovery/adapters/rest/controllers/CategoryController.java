package com.ms.discovery.adapters.rest.controllers;

import com.ms.discovery.adapters.rest.dto.CategoryDto;
import com.ms.discovery.adapters.rest.dto.SaveCategoryDto;
import com.ms.discovery.application.ports.in.CategoryInPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
//@NoArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private final CategoryInPort categoryInPort;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CategoryDto> addCategory(@RequestBody SaveCategoryDto categoryDto) {
        int userId = categoryInPort.addCategory(categoryDto);
        if (userId > 0) {
            return new ResponseEntity<>(CategoryDto.builder().build(), HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
