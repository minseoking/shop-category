package com.ms.discovery.adapters.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.discovery.adapters.jpa.repository.CategoryRepository;
import com.ms.discovery.adapters.rest.dto.SaveCategoryDto;
import com.ms.discovery.application.ports.in.CategoryInPort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
@AutoConfigureMockMvc
class CategoryControllerTest {

    @MockBean
    private CategoryInPort categoryInPort;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String URL = "/api/categories";

    @Test
    public void addCategoryControllerTest() throws Exception {
        SaveCategoryDto category = SaveCategoryDto.builder()
                .name("상의")
                .build();
        String body = objectMapper.writeValueAsString(category);

        mvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isCreated());
    }

    @Test
    public void updateCategoryControllerTest() throws Exception {
        SaveCategoryDto category = SaveCategoryDto.builder()
                .name("상의")
                .build();
        String body = objectMapper.writeValueAsString(category);

        mvc.perform(put(URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteCategoryControllerTest() throws Exception {
        mvc.perform(delete(URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void getCategoryControllerTest() throws Exception {
        mvc.perform(get(URL))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}