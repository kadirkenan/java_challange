package com.enoca.service.order;

import com.enoca.model.order.OrderResponse;

import java.util.List;

public interface IOrderService {
    List<OrderResponse> GetAllOrdersForCustomer();
}
