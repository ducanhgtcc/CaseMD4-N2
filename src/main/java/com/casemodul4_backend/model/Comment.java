package com.casemodul4_backend.model;



import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public String content;

    @ManyToOne
    private Account account;
    @ManyToOne
    private Product product;
}
