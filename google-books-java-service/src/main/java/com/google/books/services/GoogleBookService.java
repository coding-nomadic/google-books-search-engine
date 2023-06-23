package com.google.books.services;

import com.google.books.client.ElasticSearchClient;
import com.google.books.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class GoogleBookService {

    @Autowired
    private ElasticSearchClient elasticSearchClient;

    /** retrieves all books **/
    public Mono<List<Book>> getAllBooks() {
        return elasticSearchClient.getAllGoogleBooks();
    }

    /** retrieves books by search **/
    public Mono<List<Book>> searchBooks(String title) {
        return elasticSearchClient.searchBooks(title);
    }
}
