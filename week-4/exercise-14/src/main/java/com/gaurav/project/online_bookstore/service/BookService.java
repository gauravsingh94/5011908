package com.gaurav.project.online_bookstore.service;

import com.gaurav.project.online_bookstore.dto.BookDTO;
import com.gaurav.project.online_bookstore.exception.ResourceNotFoundException;
import com.gaurav.project.online_bookstore.mapper.BookMapper;
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

    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(BookMapper.INSTANCE::bookToBookDTO).toList();
    }

    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
        return BookMapper.INSTANCE.bookToBookDTO(book);
    }

    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.bookDTOToBook(bookDTO);
        book = bookRepository.save(book);
        return BookMapper.INSTANCE.bookToBookDTO(book);
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book existingBook = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));

        existingBook.setTitle(bookDTO.getTitle());
        existingBook.setAuthor(bookDTO.getAuthor());

        Book updatedBook = bookRepository.save(existingBook);
        return BookMapper.INSTANCE.bookToBookDTO(updatedBook);
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book with ID " + id + " not found.");
        }
        bookRepository.deleteById(id);
    }
}