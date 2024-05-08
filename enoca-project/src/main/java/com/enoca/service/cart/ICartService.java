package com.enoca.service.cart;

import com.enoca.model.cart.CartResponse;
import com.enoca.model.cart.CartUpdate;

import java.util.List;

public interface ICartService {
    List<CartResponse> findAll();

    CartResponse findById(String id);

    CartResponse update(CartUpdate cartUpdate);

    void addProductToCart(String customerId, String productId);
}
