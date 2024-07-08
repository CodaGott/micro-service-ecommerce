package com.dozie.ecommerce.dto.mapper;

import com.dozie.ecommerce.dto.ProductPurchaseResponse;
import com.dozie.ecommerce.dto.ProductRequest;
import com.dozie.ecommerce.dto.ProductResponse;
import com.dozie.ecommerce.model.Category;
import com.dozie.ecommerce.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product toProduct(ProductRequest request) {
        return Product.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .availableBalance(request.getAvailableBalance())
                .category(Category.builder().id(request.getId()).build())
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableBalance(),
                product.getPrice(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }

    public ProductPurchaseResponse toProductPurchaseResponse(Product product, Double quantity) {
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getAvailableBalance()
        );
    }
}
