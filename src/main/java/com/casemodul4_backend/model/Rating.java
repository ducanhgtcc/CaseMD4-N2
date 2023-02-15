package com.casemodul4_backend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    float point;
    @ManyToOne
    Account account;
    @ManyToOne
    Product product;


}
