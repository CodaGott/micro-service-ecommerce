package com.dozie.ecommerce.controllers;

import com.dozie.ecommerce.dto.ProductPurchaseRequest;
import com.dozie.ecommerce.dto.ProductPurchaseResponse;
import com.dozie.ecommerce.dto.ProductResponse;
import com.dozie.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dozie.ecommerce.dto.ProductRequest;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Integer> createProduct(@RequestBody @Valid ProductRequest product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProduct(@RequestBody @Valid List<ProductPurchaseRequest> request) {
        return ResponseEntity.ok(productService.purchaseProduct(request));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable("product-id") Integer productId){
        return ResponseEntity.ok(productService.findProductById(productId));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }
}
