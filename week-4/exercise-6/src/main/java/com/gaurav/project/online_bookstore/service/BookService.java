package com.gaurav.project.online_bookstore.service;

import com.gaurav.project.online_bookstore.exception.ResourceNotFoundException;
import com.gaurav.project.online_bookstore.model.Book;
import com.gaurav.project.online_bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book with ID " + id + " not found.");
        }
        bookRepository.deleteById(id);
    }

    public List<Book> getBooksByParams(String title, String author) {
        if (title != null && author != null) {
            return bookRepository.findByTitleAndAuthor(title, author);
        } else if (title != null) {
            return bookRepository.findByTitle(title);
        } else if (author != null) {
            return bookRepository.findByAuthor(author);
        } else {
            return bookRepository.findAll();
        }
    }
}
