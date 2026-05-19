package com.shopflow.order_service.model;

import com.shopflow.order_service.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "orders")
@Data
public class Order {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private Long userid;


private Long productid;


private int quantity;

@Enumerated(EnumType.STRING)
private OrderStatus orderstatus;

@CreationTimestamp
private LocalDateTime orderPlacedDate;
}
