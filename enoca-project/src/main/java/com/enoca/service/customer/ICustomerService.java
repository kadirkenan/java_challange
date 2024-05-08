package com.enoca.service.customer;

import com.enoca.model.customer.CustomerRequest;
import com.enoca.model.customer.CustomerResponse;

public interface ICustomerService {
    CustomerResponse addCustomer(CustomerRequest customerRequest);
}
