package com.dozie.ecommerce.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    private Integer id;
    @NotNull(message = "Product name is required")
    private String name;
    @NotNull(message = "Product name is required")
    private String description;
    @Positive(message = "Available quantity should be positive")
    private Double availableBalance;
    @Positive(message = "Product price should be Positive")
    private BigDecimal price;
    @NotNull(message = "Product category is required")
    private Integer categoryId;
}
