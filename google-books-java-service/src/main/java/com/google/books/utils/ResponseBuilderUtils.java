package com.google.books.utils;

import com.google.books.models.Book;
import com.google.books.models.Hit;
import com.google.books.models.Response;
import com.google.books.models.Root;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public final class ResponseBuilderUtils {
    private ResponseBuilderUtils() {
    }

    public static Book prepare(Object object) {
        try {
            Optional<Response> response = Optional.ofNullable(JsonUtils.getObject(JsonUtils.toString(object), Response.class));
            return response.map(Response::get_source).orElseGet(Book::new);
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
            return Book.builder().build();
        }
    }

    public static List<Book> apiResponse(Object object) {
        try {
            Root response = JsonUtils.getObject(JsonUtils.toString(object), Root.class);
            return response.getHits().getHits().stream().map(ResponseBuilderUtils::setBooks).collect(Collectors.toList());
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
            return new ArrayList<>();
        }
    }

    private static Book setBooks(Hit hit) {
        return Book.builder()
                .id(hit.get_source().getId())
                .authors(hit.get_source().getVolumeInfo().getAuthors())
                .description(hit.get_source().getVolumeInfo().getDescription())
                .categories(hit.get_source().getVolumeInfo().getCategories())
                .publisher(hit.get_source().getVolumeInfo().getPublisher())
                .publishedDate(hit.get_source().getVolumeInfo().getPublishedDate())
                .title(hit.get_source().getVolumeInfo().getTitle())
                .subtitle(hit.get_source().getVolumeInfo().getSubtitle())
                .language(hit.get_source().getVolumeInfo().getLanguage())
                .build();
    }
}
