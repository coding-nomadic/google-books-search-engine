package com.google.books.controllers;

import com.google.books.models.Book;
import com.google.books.services.GoogleBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin
public class GoogleBooksController {

    private final GoogleBookService googleBookService;

    @Autowired
    public GoogleBooksController(GoogleBookService googleBookService) {
        this.googleBookService = googleBookService;
    }

    @GetMapping("/all")
    public Mono<List<Book>> getAllBooks() {
        return googleBookService.getAllBooks();
    }

    @GetMapping
    public Mono<List<Book>> searchBooks(@RequestParam String search) {
        return googleBookService.searchBooks(search);
    }
}
