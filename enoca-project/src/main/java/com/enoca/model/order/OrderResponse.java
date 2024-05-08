package com.enoca.model.order;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponse {
    private String id;
    private String customerId;
    private List<String> productIds;
    private BigDecimal totalAmount;
    private int adet;
    private LocalDateTime orderDate;
}