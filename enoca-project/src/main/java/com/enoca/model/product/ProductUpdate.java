package com.enoca.model.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUpdate {
    private String productName;
    private BigDecimal price;
    private Integer stock;
}