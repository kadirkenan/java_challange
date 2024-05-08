package com.enoca.mapper;

import com.enoca.entitiy.Order;
import com.enoca.model.order.OrderRequest;
import com.enoca.model.order.OrderResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderResponse mapResponseToEntity(Order order);

    Order mapRequestToEntity(OrderRequest orderRequest);

    List<OrderResponse> mapResponseToEntityList(List<Order> orders);
}