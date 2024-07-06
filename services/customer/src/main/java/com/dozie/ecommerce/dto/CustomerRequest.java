package com.dozie.ecommerce.dto;

import com.dozie.ecommerce.model.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
public record CustomerRequest(
        String id,
        @NotNull(message = "Customer first name is required")
        String firstName,
        @NotNull(message = "Customer last name is required")
        String lastName,
        @NotNull(message = "Customer email is required")
        @Email(message = "Not a Valid email address")
        String email,
        Address address,
        String phone
) {
}
