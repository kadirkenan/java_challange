package com.enoca.mapper;

import com.enoca.entitiy.Customer;
import com.enoca.model.customer.CustomerRequest;
import com.enoca.model.customer.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CartMapper.class, OrderMapper.class})
public interface CustomerMapper {
    CustomerResponse mapResponseToEntity(Customer customer);

    Customer mapRequestToEntity(CustomerRequest customerRequest);
}