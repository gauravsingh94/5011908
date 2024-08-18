package com.gaurav.project.online_bookstore.repository;

import com.gaurav.project.online_bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

