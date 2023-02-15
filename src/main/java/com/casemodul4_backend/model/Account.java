package com.casemodul4_backend.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String avatar;
    private String address;
    private String phone;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;
}
