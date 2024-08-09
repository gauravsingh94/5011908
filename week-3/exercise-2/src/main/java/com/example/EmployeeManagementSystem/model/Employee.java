package com.example.EmployeeManagementSystem.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.swing.*;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
