package com.dozie.ecommerce.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductResponse
        (
            Integer id,
            String name,
            String description,
            Double availableBalance,
            BigDecimal price,
            Integer categoryId,
            String categoryName,
            String categoryDesc
        ) {
}
