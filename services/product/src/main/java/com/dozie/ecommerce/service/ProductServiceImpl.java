package com.dozie.ecommerce.service;

import com.dozie.ecommerce.dto.ProductPurchaseRequest;
import com.dozie.ecommerce.dto.ProductPurchaseResponse;
import com.dozie.ecommerce.dto.ProductRequest;
import com.dozie.ecommerce.dto.ProductResponse;
import com.dozie.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public Integer createProduct(ProductRequest product) {
        return 0;
    }

    @Override
    public List<ProductPurchaseResponse> purchaseProduct(List<ProductPurchaseRequest> request) {
        return List.of();
    }

    @Override
    public ProductResponse findProductById(Integer productId) {
        return null;
    }

    @Override
    public List<ProductResponse> findAll() {
        return List.of();
    }
}
