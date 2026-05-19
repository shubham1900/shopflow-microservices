package com.shopflow.order_service.service;


import com.shopflow.order_service.OrderStatus;
import com.shopflow.order_service.client.ProductClient;
import com.shopflow.order_service.dto.ProductDTO;
import com.shopflow.order_service.model.Order;
import com.shopflow.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {


    private final OrderRepository orderRepository;

    private final ProductClient productClient;

    public Order createOrder(Order order) {


            ProductDTO product = productClient.getProductById(order.getProductid());

        if(product == null) {
            throw new RuntimeException(
                    "Product not found!");
        }
            if(product.getStock()<1){
                throw new RuntimeException("Stock not available");
            }
            else {
                order.setOrderstatus(OrderStatus.PENDING);
                return orderRepository.save(order);
            }
    }

    public Order updateOrderStatus(Long orderId, OrderStatus status) {
        Order order = orderRepository.findById(orderId).orElseThrow(() ->
                new RuntimeException("Order not found with id: " + orderId));
        if (order != null) {
            order.setOrderstatus(status);
            return orderRepository.save(order);
        }
        return null;
    }

    public Order findOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
    }

    public Order findOrderByIdAndStatus(Long orderId, String status) {
        return orderRepository.findByIdAndOrderstatus(orderId, OrderStatus.valueOf(status))
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId + " and status: " + status));
    }

    public List<Order> findOrderByUser(Long userid) {
        return orderRepository.findByUserid(userid);
    }


}
