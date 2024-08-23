package com.gaurav.project.online_bookstore.controller;

import com.gaurav.project.online_bookstore.model.Book;
import com.gaurav.project.online_bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Endpoint to fetch all books or filter by query parameters
    @GetMapping
    public ResponseEntity<List<Book>> getBooksByParams(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author) {
        List<Book> books = bookService.getBooksByParams(title, author);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Books-Fetched");
        return new ResponseEntity<>(books, headers, HttpStatus.OK);
    }

    // Endpoint to fetch a book by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "Book-Found");
            return new ResponseEntity<>(book.get(), headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "Book-Not-Found");
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to create a new book
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.saveBook(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/books/" + savedBook.getId());
        return new ResponseEntity<>(savedBook, headers, HttpStatus.CREATED);
    }

    // Endpoint to update an existing book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        if (bookService.getBookById(id).isPresent()) {
            book.setId(id);
            Book updatedBook = bookService.saveBook(book);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "Book-Updated");
            return new ResponseEntity<>(updatedBook, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "Book-Not-Found");
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete a book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (bookService.getBookById(id).isPresent()) {
            bookService.deleteBook(id);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "Book-Deleted");
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "Book-Not-Found");
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
    }
}
