package com.gaurav.project.online_bookstore.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
}
