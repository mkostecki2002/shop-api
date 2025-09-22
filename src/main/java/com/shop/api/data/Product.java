package com.shop.api.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "Products")
@Getter
@Setter
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
