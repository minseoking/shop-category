package com.ms.discovery.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class Category {
    private Integer id;

//    @NonNull
    private String name;
}
