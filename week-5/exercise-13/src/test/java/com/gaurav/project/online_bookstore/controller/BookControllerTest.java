package com.gaurav.project.online_bookstore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaurav.project.online_bookstore.dto.BookDTO;
import com.gaurav.project.online_bookstore.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void testCreateBook() throws Exception {
        BookDTO bookDTO = new BookDTO(1L, "Book Title", "Book Author");
        when(bookService.saveBook(any(BookDTO.class))).thenReturn(bookDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bookDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Book Title"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("Book Author"))
                .andDo(print());
    }

    @Test
    public void testGetAllBooks() throws Exception {
        BookDTO bookDTO = new BookDTO(1L, "Book Title", "Book Author");
        when(bookService.getAllBooks()).thenReturn(List.of(bookDTO));

        mockMvc.perform(MockMvcRequestBuilders.get("/books")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("Book Title"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].author").value("Book Author"))
                .andDo(print());
    }

    @Test
    public void testGetBookById() throws Exception {
        BookDTO bookDTO = new BookDTO(1L, "Book Title", "Book Author");
        when(bookService.getBookById(anyLong())).thenReturn(bookDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/books/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Book Title"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("Book Author"))
                .andDo(print());
    }

    @Test
    public void testUpdateBook() throws Exception {
        BookDTO bookDTO = new BookDTO(1L, "Updated Title", "Updated Author");
        when(bookService.updateBook(anyLong(), any(BookDTO.class))).thenReturn(bookDTO);

        mockMvc.perform(MockMvcRequestBuilders.put("/books/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bookDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Updated Title"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("Updated Author"))
                .andDo(print());
    }

    @Test
    public void testDeleteBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/books/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(print());
    }
}
