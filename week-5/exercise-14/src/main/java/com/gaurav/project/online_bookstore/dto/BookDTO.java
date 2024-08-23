package com.gaurav.project.online_bookstore.dto;

public class BookDTO {
    private Long id;
    private String title;
    private String author;

    // Default constructor
    public BookDTO() {
    }

    // Constructor with parameters
    public BookDTO(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
