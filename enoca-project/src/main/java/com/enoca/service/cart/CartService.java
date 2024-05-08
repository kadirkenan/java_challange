package com.enoca.service.cart;

import com.enoca.entitiy.Cart;
import com.enoca.entitiy.Customer;
import com.enoca.entitiy.Order;
import com.enoca.entitiy.Product;
import com.enoca.exception.CustomNotFoundException;
import com.enoca.mapper.CartMapper;
import com.enoca.model.cart.CartResponse;
import com.enoca.model.cart.CartUpdate;
import com.enoca.repository.CartRepository;
import com.enoca.repository.CustomerRepository;
import com.enoca.repository.OrderRepository;
import com.enoca.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService {
    private CartRepository cartRepository;
    private CartMapper cartMapper;
    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    @Override
    public List<CartResponse> findAll() {
        List<Cart> carts = cartRepository.findAll();
        return cartMapper.mapResponseToEntityList(carts);
    }

    @Override
    public CartResponse findById(String id) {
        Cart cart = cartRepository.findById(id).orElseThrow(() -> new CustomNotFoundException("Cart not found"));
        return cartMapper.mapResponseToEntity(cart);
    }

    @Override
    public CartResponse update(CartUpdate cartUpdate) {
        Cart cart = cartMapper.mapUpdateToEntity(cartUpdate);
        Cart savedEntity = cartRepository.save(cart);
        return cartMapper.mapResponseToEntity(savedEntity);
    }

    @Override
    public void addProductToCart(String customerId, String productId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomNotFoundException("Customer not found: " + customerId));

        Cart cart = customer.getCart();
        if (cart == null) {
            cart = new Cart();
            customer.setCart(cart);
        }
        List<Product> products = cart.getProducts();
        if (products == null) {
            products = new ArrayList<>();
            cart.setProducts(products);
        }
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new CustomNotFoundException("Product not found: " + productId));

        checkProductBeforeAddingToCart(customer, product);
        products.add(product);
        cart.setProducts(products);

        BigDecimal totalAmount = cart.getTotalAmount().add(product.getPrice());
        cart.setTotalAmount(totalAmount);

        cartRepository.save(cart);
        saveOrder(customer, product);
    }

    private void checkProductBeforeAddingToCart(Customer customer, Product product) {
        List<Product> products = customer.getCart().getProducts();
        Optional<Product> existingProduct = products.stream()
                .filter(p -> p.getId().equals(product.getId()))
                .findFirst();
        if (existingProduct.isPresent()) {
            Product foundProduct = existingProduct.get();
            foundProduct.setQuantity(foundProduct.getQuantity() + 1);
        } else {
            products.add(product);
        }
        if (product.getStock() == 0) {
            throw new CustomNotFoundException("Product out of stock: " + product.getId());
        }
    }

    private void saveOrder(Customer customer, Product product) {
        Order order = new Order();
        order.setCustomerId(customer.getId());
        order.getProductIds().add(product.getId());
        order.setTotalAmount(product.getPrice());
        order.setOrderDate(LocalDateTime.now());

        orderRepository.save(order);
    }
}
