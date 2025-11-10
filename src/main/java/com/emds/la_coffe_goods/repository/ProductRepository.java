package com.emds.la_coffe_goods.repository;

import com.emds.la_coffe_goods.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
