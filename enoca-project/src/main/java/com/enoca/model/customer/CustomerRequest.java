package com.enoca.model.customer;

import lombok.Data;

import java.util.List;

@Data
public class CustomerRequest {
    private String name;
    private String lastname;
    private String cartId;
    private List<String> orderIds;
}
