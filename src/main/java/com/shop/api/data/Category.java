package com.shop.api.data;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Categories")
@Data
public class Category {
    @Id
    private String name;
    private String description;
    private String image;
    private Boolean isFeatured;
}
