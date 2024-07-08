package com.dozie.ecommerce.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class ProductPurchaseRequest {
    @NotNull(message = "Product Id is required")
    @Positive(message = "Product id should be Positive")
    private Integer productId;
    @Positive(message = "Product quantity should be Positive")
    @NotNull(message = "Product quantity is required")
    private Double quantity;
}
