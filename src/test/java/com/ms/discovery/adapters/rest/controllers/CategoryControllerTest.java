package com.ms.discovery.adapters.rest.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
class CategoryControllerTest {

    @Test
    void addCategory() {
        /*SaveUserBodyDto saveUserBodyDto = fakeSaveUserBodyDto();

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(saveUserBodyDto)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("first_name", is(saveUserBodyDto.getFirstName())))
            .andExpect(jsonPath("last_name", is(saveUserBodyDto.getLastName())))
            .andExpect(jsonPath("phone", is(saveUserBodyDto.getPhone())));*/
    }
}