package com.google.books.services;

import com.google.books.client.ElasticSearchClient;
import com.google.books.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class GoogleBookService {

    private final ElasticSearchClient elasticSearchClient;

    @Autowired
    public GoogleBookService(ElasticSearchClient elasticSearchClient) {
        this.elasticSearchClient = elasticSearchClient;
    }

    public Mono<List<Book>> getAllBooks() {
        return elasticSearchClient.getAllGoogleBooks();
    }

    public Mono<List<Book>> searchBooks(String title) {
        return elasticSearchClient.searchBooks(title);
    }
}
