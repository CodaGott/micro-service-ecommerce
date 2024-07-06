package com.dozie.ecommerce.service;

import com.dozie.ecommerce.dto.ProductPurchaseRequest;
import com.dozie.ecommerce.dto.ProductPurchaseResponse;
import com.dozie.ecommerce.dto.ProductRequest;
import com.dozie.ecommerce.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    Integer createProduct(ProductRequest product);

    List<ProductPurchaseResponse> purchaseProduct(List<ProductPurchaseRequest> request);

    ProductResponse findProductById(Integer productId);

    List<ProductResponse> findAll();
}
