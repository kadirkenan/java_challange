package com.enoca.controller;

import com.enoca.model.cart.CartResponse;
import com.enoca.model.cart.CartUpdate;
import com.enoca.service.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private CartService cartService;

    @GetMapping
    public ResponseEntity<List<CartResponse>> findAll() {
        return ResponseEntity.ok(cartService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartResponse> findById(String id) {
        return ResponseEntity.ok(cartService.findById(id));
    }

    @PutMapping
    public ResponseEntity<CartResponse> update(@RequestBody CartUpdate cartUpdate) {
        return ResponseEntity.ok(cartService.update(cartUpdate));
    }

    @PostMapping("/{customerId}/cart/products/{productId}")
    public ResponseEntity<Void> addToCart(@PathVariable("customerId") String customerId, @PathVariable("productId") String productId) {
        cartService.addProductToCart(customerId, productId);
        return ResponseEntity.ok().build();
    }
}
