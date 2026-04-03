//ATE/4355/14
package com.shopwave.service;

import com.shopwave.dto.*;
import com.shopwave.model.*;
import com.shopwave.repository.OrderRepository;
import com.shopwave.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderService(ProductRepository productRepository,
                        OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    //  CREATE ORDER
    public OrderResponse createOrder(OrderRequest request) {

        Order order = new Order();
        order.setStatus(OrderStatus.PENDING);
        order.setCreatedAt(LocalDateTime.now());

        // generate order number
        order.setOrderNumber("ORD-" + UUID.randomUUID().toString().substring(0, 8));

        List<OrderItem> orderItems = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;

        for (OrderItemRequest itemRequest : request.getItems()) {

            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(itemRequest.getQuantity());
            item.setUnitPrice(product.getPrice());
            item.setOrder(order);

            // calculate item total
            BigDecimal itemTotal = product.getPrice()
                    .multiply(BigDecimal.valueOf(itemRequest.getQuantity()));

            total = total.add(itemTotal);

            orderItems.add(item);
        }

        order.setItems(orderItems);
        order.setTotalAmount(total);

        Order savedOrder = orderRepository.save(order);

        return mapToResponse(savedOrder);
    }

    //  GET ALL ORDERS
    public List<OrderResponse> getAllOrders() {

        List<Order> orders = orderRepository.findAll();
        List<OrderResponse> responses = new ArrayList<>();

        for (Order order : orders) {
            responses.add(mapToResponse(order));
        }

        return responses;
    }

    //  GET ORDER BY ID
    public OrderResponse getOrderById(Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return mapToResponse(order);
    }

    //  UPDATE ORDER STATUS
    public OrderResponse updateOrderStatus(Long id, OrderStatus status) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(status);

        Order updated = orderRepository.save(order);

        return mapToResponse(updated);
    }

    //  DTO MAPPER
    private OrderResponse mapToResponse(Order order) {

        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setOrderNumber(order.getOrderNumber());
        response.setStatus(order.getStatus().name());
        response.setTotalAmount(order.getTotalAmount());
        response.setCreatedAt(order.getCreatedAt());

        List<OrderItemResponse> items = new ArrayList<>();

        for (OrderItem item : order.getItems()) {
            OrderItemResponse ir = new OrderItemResponse();
            ir.setProductName(item.getProduct().getName());
            ir.setQuantity(item.getQuantity());
            ir.setUnitPrice(item.getUnitPrice());
            items.add(ir);
        }

        response.setItems(items);

        return response;
    }
}