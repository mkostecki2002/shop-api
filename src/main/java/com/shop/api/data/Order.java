package com.shop.api.data;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private UUID id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;
    @OneToMany
    private List<OrderProduct> orderItems;
}
