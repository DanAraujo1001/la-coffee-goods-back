package com.emds.la_coffe_goods.dto;

import com.emds.la_coffe_goods.util.CategoryItem;

public record ProductRequestDTO(String name,
                                CategoryItem category,
                                String description,
                                Double price,
                                String image,
                                Boolean available) {
}
