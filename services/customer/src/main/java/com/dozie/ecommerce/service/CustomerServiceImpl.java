package com.dozie.ecommerce.service;

import com.dozie.ecommerce.customer.Customer;
import com.dozie.ecommerce.dto.CustomerRequest;
import com.dozie.ecommerce.dto.response.CustomerResponse;
import com.dozie.ecommerce.exception.CustomerNotFoundException;
import com.dozie.ecommerce.service.mapper.CustomerMapper;
import com.dozie.ecommerce.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public String createCustomer(CustomerRequest request) {
        var customer = customerRepository.save(customerMapper.dtoToCustomer(request));
        return customer.getId();
    }

    @Override
    public void updateCustomer(CustomerRequest request) {
        var customer = customerRepository.findById(request.id()).orElseThrow(() -> new CustomerNotFoundException(
                format("Customer with id %s not found", request.id())
        ));
        mergeCustomer(customer, request);
        customerRepository.save(customer);
    }

    @Override
    public List<CustomerResponse> findAllCustomers(){
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::fromCustomer)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean existsById(String customerId) {
        return customerRepository.findById(customerId).isPresent();
    }

    @Override
    public CustomerResponse findById(String customerId) {
        return customerRepository.findById(customerId)
                .map(customerMapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(format("Customer with id %s not found", customerId)));
    }

    @Override
    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }

    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstName())) {
            customer.setFirstName(request.firstName());
        }
        if (StringUtils.isNotBlank(request.lastName())) {
            customer.setLastName(request.lastName());
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if (StringUtils.isNotBlank(request.phone())) {
            customer.setEmail(request.phone());
        }
        if (request.address() != null){
            customer.setAddress(request.address());
        }
    }
}
