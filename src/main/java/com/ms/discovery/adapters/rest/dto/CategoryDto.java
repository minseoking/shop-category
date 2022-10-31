package com.ms.discovery.adapters.rest.dto;

import com.ms.discovery.domain.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@Schema(description = "카테고리 응답DTO")
public class  CategoryDto {

    @Schema(description = "아이디")
    private Integer id;
    @Schema(description = "카테고리 이름")
    private String name;
    @Schema(description = "하위 카테고리")
    private List<CategoryDto> children;

    public static CategoryDto of(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getChildren().stream().map(CategoryDto::of).collect(Collectors.toList())
        );
    }
}
