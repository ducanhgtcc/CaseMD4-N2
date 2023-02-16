package com.casemodul4_backend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private double price;
    private String status;
    private float avgPoint;

    @ManyToOne
    private Category category;
}
