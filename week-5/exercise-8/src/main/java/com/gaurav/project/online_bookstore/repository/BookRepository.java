package com.gaurav.project.online_bookstore.repository;

import com.gaurav.project.online_bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleAndAuthor(String title, String author);

    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);
}

