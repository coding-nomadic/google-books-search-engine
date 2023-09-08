package com.google.books.client;

import com.google.books.configs.AppConfig;
import com.google.books.exceptions.BookException;
import com.google.books.models.Book;
import com.google.books.utils.JsonUtils;
import com.google.books.utils.ResponseBuilderUtils;
import com.google.books.utils.UrlBuilderUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@Slf4j
public class ElasticSearchClient {

    private final AppConfig appConfig;
    private final WebClient.Builder webClientBuilder;

    @Autowired
    public ElasticSearchClient(AppConfig appConfig, WebClient.Builder webClientBuilder) {
        this.appConfig = appConfig;
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<List<Book>> getAllGoogleBooks() {
        final String allBooksUrl = UrlBuilderUtils.getAllBooks(appConfig);
        return webClientBuilder.build()
                .post()
                .uri(allBooksUrl)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(JsonUtils.requestBodyJson("1000")), String.class)
                .retrieve()
                .onStatus(HttpStatus::isError, response -> handleErrorResponse("Get All Books", response))
                .bodyToMono(Object.class)
                .flatMap(response -> Mono.just(ResponseBuilderUtils.apiResponse(response)));
    }

    public Mono<List<Book>> searchBooks(String title) {
        final String searchBooksUrl = UrlBuilderUtils.getSearchBook(appConfig, title);
        return webClientBuilder.build()
                .get()
                .uri(searchBooksUrl)
                .retrieve()
                .onStatus(HttpStatus::isError, response -> handleErrorResponse("Get Searched Books", response))
                .bodyToMono(Object.class)
                .flatMap(response -> Mono.just(ResponseBuilderUtils.apiResponse(response)));
    }

    private Mono<? extends Throwable> handleErrorResponse(String operation, ClientResponse response) {
        log.error(String.format("Error calling Elastic API to %s due to: %s", operation, response.statusCode()));
        return Mono.error(new BookException(response.toString(), "102"));
    }
}
