package com.enoca.controller;

import com.enoca.model.product.ProductRequest;
import com.enoca.model.product.ProductResponse;
import com.enoca.service.product.ProductService;
import com.enoca.model.product.ProductUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productService.createProduct(productRequest));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable String id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PutMapping
    public ResponseEntity<ProductResponse> update(@RequestBody ProductUpdate productUpdate) {
        return ResponseEntity.ok(productService.update(productUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
