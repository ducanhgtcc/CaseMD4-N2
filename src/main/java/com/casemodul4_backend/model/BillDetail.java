package com.casemodul4_backend.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int amount;
    @ManyToOne
    private Bill bill;
    @ManyToOne
    private Product product;
}
