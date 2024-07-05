package com.dozie.ecommerce.service;

import com.dozie.ecommerce.dto.CustomerRequest;
import com.dozie.ecommerce.dto.response.CustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    String createCustomer(CustomerRequest request);

    void updateCustomer(CustomerRequest request);
    List<CustomerResponse> findAllCustomers();

    Boolean existsById(String customerId);

    CustomerResponse findById(String customerId);

    void deleteCustomer(String customerId);
}
