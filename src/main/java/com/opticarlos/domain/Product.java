package com.opticarlos.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class Product {

    private Long productId;

    private String name;

    private Double price;

    private String brand;

    private Gender gender;

    private Category category;

    private boolean active;

    private int stock;

    private String description;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;

    private String image;

}
