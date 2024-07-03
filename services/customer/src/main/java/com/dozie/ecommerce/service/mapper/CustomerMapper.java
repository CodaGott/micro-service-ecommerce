package com.dozie.ecommerce.service.mapper;

import com.dozie.ecommerce.customer.Customer;
import com.dozie.ecommerce.dto.CustomerRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer dtoToCustomer(CustomerRequest request) {
        if (request == null) return null;
        return Customer.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .phone(request.phone())
                .address(request.address())
                .build();
    }
}
