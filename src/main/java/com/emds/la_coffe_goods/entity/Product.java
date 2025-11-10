package com.emds.la_coffe_goods.entity;

import com.emds.la_coffe_goods.dto.ProductRequestDTO;
import com.emds.la_coffe_goods.dto.ProductResponseDTO;
import com.emds.la_coffe_goods.util.CategoryItem;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "products_items")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryItem category;

    private String description;

    private Double price;

    private String image;

    private Boolean available;

    public Product(ProductRequestDTO data) {
        this.name = data.name();
        this.category = data.category();
        this.description = data.description();
        this.price = data.price();
        this.image = data.image();
        this.available = data.available();
    }

    public void updateFromDTO(ProductRequestDTO data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.category() != null) {
            this.category = data.category();
        }
        if (data.description() != null) {
            this.description = data.description();
        }
        if (data.price() != null) {
            this.price = data.price();
        }
        if (data.image() != null) {
            this.image = data.image();
        }
        if (data.available() != null) {
            this.available = data.available();
        }
    }
}
