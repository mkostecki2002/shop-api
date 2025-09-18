package com.shop.api.data;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "Addresses")
public class Address {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private UUID id;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
