package com.gaurav.project.online_bookstore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private Double price;
    private String isbn;
}
