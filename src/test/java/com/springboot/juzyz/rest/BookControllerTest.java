package com.springboot.juzyz.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.springboot.juzyz.rest.controllers.BookController;
import com.springboot.juzyz.rest.models.Book;
import com.springboot.juzyz.rest.services.BookService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {
    private MockMvc mockMvc;
    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    Book record1 = new Book(1l, "Atomic Habits", "How to build better habits", 5);
    Book record2 = new Book(2l, "Think fast and slow", "How to create goof metal models about thinking", 4);
    Book record3 = new Book(3l, "Grokking Algorithms", "Learn about algorithms the fun way", 5);

    @BeforeEach
    public void setup() {
//        MockitoAnnotations.initMocks(this); // response Body = []  --> Assertion if failed
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void getAllRecords_success() throws Exception {
        List<Book> records = Arrays.asList(record1, record2, record3);
        Mockito.when(bookService.getAllBooks()).thenReturn(records);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/book")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].name", is("Grokking Algorithms")));
    }

    @Test
    public void getBookById_success() throws Exception {
        Mockito.when(bookService.getById(Mockito.anyLong())).thenReturn(record1);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/book/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("Atomic Habits")));
    }

    @Test
    public void createRecord_success() throws Exception {
        Book book = Book.builder()
                .bookId(4l)
                .name("Instruction to C")
                .summary("The name but longer")
                .rating(3)
                .build();

        Mockito.when(bookService.addBook(Mockito.any(Book.class))).thenReturn(book);
        String content = objectWriter.writeValueAsString(book);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .post("/api/v1/book")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("Instruction to C")));
    }

    @Test
    public void updateBookRecord_success() throws Exception {
        Book updateBookRecord = Book.builder()
                .bookId(4l)
                .name("Updated Book Name")
                .summary("Updated Summary")
                .rating(1)
                .build();

        Mockito.when(bookService.updateBook( Mockito.any(Book.class))).thenReturn( updateBookRecord);
        String updatedContent = objectWriter.writeValueAsString(updateBookRecord);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .put("/api/v1/book")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(updatedContent);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("Updated Book Name")));
    }

    @Test
    public void deleteBookById_success() throws Exception {
        Mockito.doNothing().when(bookService).deleteBook(Mockito.anyLong()); //mocking void method

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/v1/book/2 ")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
