package com.gaurav.project.online_bookstore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
}