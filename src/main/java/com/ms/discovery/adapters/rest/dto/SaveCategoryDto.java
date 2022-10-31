package com.ms.discovery.adapters.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Builder
@Data
@Schema(description = "카테고리 요청DTO")
public class SaveCategoryDto {

    @NotNull
    @Schema(description = "카테고리 이름", required = true)
    private String name;
    @Schema(description = "상위 카테고리 아이디")
    private Integer parentId;
}
