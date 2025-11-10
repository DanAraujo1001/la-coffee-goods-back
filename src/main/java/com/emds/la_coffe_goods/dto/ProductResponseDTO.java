package com.emds.la_coffe_goods.dto;

import com.emds.la_coffe_goods.entity.Product;
import com.emds.la_coffe_goods.util.CategoryItem;

import java.util.UUID;

public record ProductResponseDTO(UUID id,
                                 String name,
                                 CategoryItem category,
                                 String description,
                                 Double price,
                                 String image,
                                 Boolean available) {
    public ProductResponseDTO(Product product){
        this(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getDescription(),
                product.getPrice(),
                product.getImage(),
                product.getAvailable()
        );
    }
}