package com.emds.la_coffe_goods.controller;

import com.emds.la_coffe_goods.dto.ProductRequestDTO;
import com.emds.la_coffe_goods.dto.ProductResponseDTO;
import com.emds.la_coffe_goods.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("product")
public class ProductController {


    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductResponseDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable UUID id) {

        ProductResponseDTO product = service.findById(id);

        if(product == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(product);
    }

    @PostMapping
    public void saveProduct(@RequestBody ProductRequestDTO data) {
        service.saveProduct(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable UUID id, @RequestBody ProductRequestDTO data) {
        ProductResponseDTO updateProduct = service.updateProduct(id, data);

        if(updateProduct == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID id) {
        Boolean existsProduct = service.deleteProduct(id);

        if (!existsProduct) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
