package com.enoca.model.cart;

import com.enoca.model.customer.CustomerResponse;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CartResponse {
    private BigDecimal totalAmount = BigDecimal.ZERO;
    private List<String> productIds;
    private CustomerResponse customerId;
}
