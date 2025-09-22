package com.shop.api.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Categories")
@Getter
@Setter
public class Category {
    @Id
    private String name;
    private String description;
    private String image;
    private Boolean isFeatured;
}
