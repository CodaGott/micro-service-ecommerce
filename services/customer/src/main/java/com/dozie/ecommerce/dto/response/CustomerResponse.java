package com.dozie.ecommerce.dto.response;

import com.dozie.ecommerce.model.Address;

public record CustomerResponse (
        String id,
        String firstName,
        String lastName,
        String email,
        Address address,
        String phone
){
}
