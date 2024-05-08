package com.enoca.mapper;

import com.enoca.entitiy.Product;
import com.enoca.model.product.ProductRequest;
import com.enoca.model.product.ProductResponse;
import com.enoca.model.product.ProductUpdate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse mapResponseToEntity(Product product);

    Product mapRequestToEntity(ProductRequest productRequest);

    List<ProductResponse> mapResponseToEntityList(List<Product> products);

    Product mapUpdateToEntity(ProductUpdate productUpdate);
}