package com.shopflow.order_service.controller;


import com.shopflow.order_service.OrderStatus;
import com.shopflow.order_service.model.Order;
import com.shopflow.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {


    private final OrderService orderService;


    @PostMapping("/createOrder")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @PutMapping("/updateOrderStatus/{orderId}")
    public ResponseEntity<?> upateStatus(@PathVariable Long orderId, @RequestParam OrderStatus status) {
        return ResponseEntity.ok(orderService.updateOrderStatus(orderId, status));
    }

    @GetMapping("/getOrderById/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.findOrderById(orderId));
}

    @GetMapping("/getOrderByIdAndStatus/{orderId}")
    public ResponseEntity<?> getOrderByIdAndStatus(@PathVariable Long orderId, @RequestParam String status) {
        return ResponseEntity.ok(orderService.findOrderByIdAndStatus(orderId, status));
    }

    @GetMapping("/getOrdersByUser/{userId}")
    public ResponseEntity<?> getOrdersByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.findOrderByUser(userId));
    }
}
