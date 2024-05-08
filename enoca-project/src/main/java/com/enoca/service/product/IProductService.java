package com.enoca.service.product;

import com.enoca.model.product.ProductRequest;
import com.enoca.model.product.ProductResponse;
import com.enoca.model.product.ProductUpdate;

import java.util.List;

public interface IProductService {
    ProductResponse createProduct(ProductRequest productRequest);

    List<ProductResponse> findAll();

    ProductResponse findById(String id);

    ProductResponse update(ProductUpdate productUpdate);

    void deleteById(String id);
}
