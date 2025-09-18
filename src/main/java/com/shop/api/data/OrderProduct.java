package com.shop.api.data;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
public class OrderProduct {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private UUID id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order orderId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product productId;
    private Integer quantity;
}
