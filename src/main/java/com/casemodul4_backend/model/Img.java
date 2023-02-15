package com.casemodul4_backend.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Img {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String img;

    @ManyToOne

    private Product product;
}
