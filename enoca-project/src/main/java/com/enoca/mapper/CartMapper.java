package com.enoca.mapper;

import com.enoca.entitiy.Cart;
import com.enoca.model.cart.CartResponse;
import com.enoca.model.cart.CartUpdate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, CustomerMapper.class})
public interface CartMapper {
    List<CartResponse> mapResponseToEntityList(List<Cart> carts);

    Cart mapUpdateToEntity(CartUpdate cartUpdate);

    CartResponse mapResponseToEntity(Cart cart);
}