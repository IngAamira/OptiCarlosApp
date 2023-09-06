package com.opticarlos.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class Product {


    private Long productId;


    private String name;


    private Double price;


    private String brand;


    private Gender gender;


    private boolean active;


    private Category category;

}
