package com.ms.discovery.adapters.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "categories")
//@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder()
public class CategoryData {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
}
