package com.enoca.controller;

import com.enoca.model.order.OrderResponse;
import com.enoca.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> GetAllOrdersForCustomer() {
        return ResponseEntity.ok(orderService.GetAllOrdersForCustomer());
    }
}
