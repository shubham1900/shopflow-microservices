package com.shopflow.order_service;

public enum OrderStatus {
    PENDING,
    CONFIRMED,
    PACKED,
    OUT_FOR_DELIVERY,
    DELIVERED,
    CANCELLED,
    FAILED
}
