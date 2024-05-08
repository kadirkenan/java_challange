package com.enoca.service.customer;

import com.enoca.entitiy.Customer;
import com.enoca.mapper.CustomerMapper;
import com.enoca.mapper.ProductMapper;
import com.enoca.model.customer.CustomerRequest;
import com.enoca.model.customer.CustomerResponse;
import com.enoca.repository.CustomerRepository;
import com.enoca.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;
    private ProductMapper productMapper;
    private ProductRepository productRepository;

    @Override
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer customer = customerMapper.mapRequestToEntity(customerRequest);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.mapResponseToEntity(savedCustomer);
    }
}
