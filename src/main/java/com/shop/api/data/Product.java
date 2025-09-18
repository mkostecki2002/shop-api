package com.shop.api.data;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "Products")
@Data
public class Product {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private UUID id;
    private String name;
    private String description;
    private Long price;
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_name")
    private Category category;
}
