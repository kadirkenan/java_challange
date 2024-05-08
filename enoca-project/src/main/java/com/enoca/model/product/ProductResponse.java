package com.enoca.model.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {
    private String id;
    private String productName;
    private BigDecimal price;
    private int stock;
}
