package com.enoca.model.customer;

import lombok.Data;

import java.util.List;

@Data
public class CustomerResponse {
    private String id;
    private String name;
    private String lastname;
    private String cartId;
    private List<String> orderIds;
}
