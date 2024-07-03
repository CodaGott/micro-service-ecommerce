package com.dozie.ecommerce.service;

import com.dozie.ecommerce.dto.CustomerRequest;
import org.springframework.stereotype.Service;

public interface CustomerService {
    String createCustomer(CustomerRequest request);

    void updateCustomer(CustomerRequest request);
}
