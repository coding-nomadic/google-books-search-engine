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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@Slf4j
public class ElasticSearchClient {
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private WebClient.Builder webClientBuilder;

    /**
     * fetch all the books from elastic search DB
     **/
    public Mono<List<Book>> getAllGoogleBooks() {
        final String allBooksUrl = UrlBuilderUtils.getAllBooks(appConfig);
        return webClientBuilder.build().post().uri(allBooksUrl).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).body(Mono.just(JsonUtils.requestBodyJson("1000")), String.class).retrieve().onStatus(HttpStatus::isError, response -> {
            log.error(String.format("Error calling Elastic API to Get All Books due to : %s", response.statusCode()));
            return Mono.error(new BookException(response.toString(), "102"));
        }).bodyToMono(Object.class).flatMap(response -> Mono.just(ResponseBuilderUtils.apiResponse(response)));
    }

    /**
     * fetch all the books from elastic search DB
     **/
    public Mono<List<Book>> searchBooks(String title) {
        final String searchBooksUrl = UrlBuilderUtils.getSearchBook(appConfig, title);
        return webClientBuilder.build().get().uri(searchBooksUrl).retrieve().onStatus(HttpStatus::isError, response -> {
            log.error(String.format("Error calling Elastic API to Get All Searched Books due to : %s", response.statusCode()));
            return Mono.error(new BookException(response.toString(), "102"));
        }).bodyToMono(Object.class).flatMap(response -> Mono.just(ResponseBuilderUtils.apiResponse(response)));
    }
}
