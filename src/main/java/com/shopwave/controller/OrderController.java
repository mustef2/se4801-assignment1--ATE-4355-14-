//ATE/4355/14
package com.shopwave.controller;

import com.shopwave.dto.OrderRequest;
import com.shopwave.dto.OrderResponse;
import com.shopwave.model.OrderStatus;
import com.shopwave.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // ✅ CREATE ORDER
    @PostMapping
    public OrderResponse createOrder(@RequestBody @Valid OrderRequest request) {
        return orderService.createOrder(request);
    }

    // ✅ GET ALL ORDERS
    @GetMapping
    public List<OrderResponse> getAllOrders() {
        return orderService.getAllOrders();
    }

    // ✅ GET ORDER BY ID
    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // ✅ UPDATE ORDER STATUS
    @PutMapping("/{id}/status")
    public OrderResponse updateOrderStatus(@PathVariable Long id,
                                           @RequestParam OrderStatus status) {
        return orderService.updateOrderStatus(id, status);
    }
}