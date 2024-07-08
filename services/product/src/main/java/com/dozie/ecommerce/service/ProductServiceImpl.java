package com.dozie.ecommerce.service;

import com.dozie.ecommerce.dto.ProductPurchaseRequest;
import com.dozie.ecommerce.dto.ProductPurchaseResponse;
import com.dozie.ecommerce.dto.ProductRequest;
import com.dozie.ecommerce.dto.ProductResponse;
import com.dozie.ecommerce.dto.mapper.ProductMapper;
import com.dozie.ecommerce.exception.ProductPurchaseException;
import com.dozie.ecommerce.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    @Override
    public Integer createProduct(ProductRequest request) {
        var product = mapper.toProduct(request);
        return productRepository.save(product).getId();
    }

    @Override
    public List<ProductPurchaseResponse> purchaseProduct(List<ProductPurchaseRequest> request) {
        var productIds = request.stream().map(ProductPurchaseRequest::getProductId).toList();
        var storedProducts = productRepository.findAllByIdInOrderById(productIds);

        if(productIds.size() != storedProducts.size()){
            throw new ProductPurchaseException("One or more products not found");
        }

        var storedRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::getProductId))
                .toList();
        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = storedRequest.get(i);
            if (product.getAvailableBalance() < productRequest.getQuantity()){
                throw new ProductPurchaseException("Insufficient stock quantity for product with ID: " + productRequest.getProductId());
            }
            var newAvailableQuantity = product.getAvailableBalance() - productRequest.getQuantity();
            product.setAvailableBalance(newAvailableQuantity);
            productRepository.save(product);
            purchasedProducts.add(mapper.toProductPurchaseResponse(product, productRequest.getQuantity()));
        }
        return purchasedProducts;
    }

    @Override
    public ProductResponse findProductById(Integer productId) {
        return productRepository.findById(productId)
                .map(mapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with the ID : " + productId));
    }

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(mapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
