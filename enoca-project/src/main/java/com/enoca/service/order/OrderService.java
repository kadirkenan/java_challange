package com.enoca.service.order;

import com.enoca.entitiy.Order;
import com.enoca.mapper.OrderMapper;
import com.enoca.model.order.OrderResponse;
import com.enoca.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {
    private OrderRepository orderRepository;
    private OrderMapper orderMapper;

    @Override
    public List<OrderResponse> GetAllOrdersForCustomer() {
        List<Order> orders = orderRepository.findAll();
        return orderMapper.mapResponseToEntityList(orders);
    }
}
