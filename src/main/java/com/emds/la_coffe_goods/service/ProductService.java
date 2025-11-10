package com.emds.la_coffe_goods.service;

import com.emds.la_coffe_goods.dto.ProductRequestDTO;
import com.emds.la_coffe_goods.dto.ProductResponseDTO;
import com.emds.la_coffe_goods.entity.Product;
import com.emds.la_coffe_goods.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductResponseDTO> findAll() {
        return repository.findAll().stream().map(ProductResponseDTO::new).toList();
    }

    public ProductResponseDTO findById(UUID id) {
        Optional<Product> productOptional = repository.findById(id);

        if (productOptional.isPresent()){
            return new ProductResponseDTO(productOptional.get());
        }

        return null;
    }

    public void saveProduct(ProductRequestDTO data) {
        Product productData = new Product(data);
        repository.save(productData);
    }

    public ProductResponseDTO updateProduct(UUID id, ProductRequestDTO data) {
        Product product = repository.findById(id).orElse(null);

        if(product == null) {
            return null;
        }

        product.updateFromDTO(data);

        Product updatedProduct = repository.save(product);

        return new ProductResponseDTO(updatedProduct);
    }

    public Boolean deleteProduct(UUID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }
}
