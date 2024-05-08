package com.enoca.service.product;

import com.enoca.entitiy.Product;
import com.enoca.exception.CustomNotFoundException;
import com.enoca.mapper.ProductMapper;
import com.enoca.model.product.ProductRequest;
import com.enoca.model.product.ProductResponse;
import com.enoca.model.product.ProductUpdate;
import com.enoca.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = productMapper.mapRequestToEntity(productRequest);
        Product save = productRepository.save(product);
        return productMapper.mapResponseToEntity(save);
    }

    @Override
    public List<ProductResponse> findAll() {
        List<Product> products = productRepository.findAll();
        return productMapper.mapResponseToEntityList(products);
    }

    @Override
    public ProductResponse findById(String id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new CustomNotFoundException("Product not found"));
        return productMapper.mapResponseToEntity(product);
    }

    @Override
    public ProductResponse update(ProductUpdate productUpdate) {
        Product product = productMapper.mapUpdateToEntity(productUpdate);
        Product savedEntity = productRepository.save(product);
        return productMapper.mapResponseToEntity(savedEntity);
    }

    @Override
    public void deleteById(String id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setDeletedDate(new Date());
            productRepository.delete(product);
        } else {
            throw new CustomNotFoundException("Product not found");
        }
    }
}
