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

    /**
     * @param object
     * @return
     */
    public static Book prepare(Object object) {
        try {
            Optional<Response> response = Optional.ofNullable(JsonUtils.getObject(JsonUtils.toString(object), Response.class));
            return !response.isEmpty() ? response.get().get_source() : new Book();
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        }
        return new Book();
    }

    /**
     * @param object
     * @return
     */
    public static List<Book> apiResponse(Object object) {
        try {
            Root response = JsonUtils.getObject(JsonUtils.toString(object), Root.class);
            return response.getHits().getHits().stream().map(s -> setBooks(s)).collect(Collectors.toList());
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        }
        return new ArrayList<>();
    }

    /**
     * @param hit
     * @return
     */
    private static Book setBooks(Hit hit) {
        Book book = new Book();
        book.setId(hit.get_source().getId());
        book.setAuthors(hit.get_source().getVolumeInfo().getAuthors());
        book.setDescription(hit.get_source().getVolumeInfo().getDescription());
        book.setCategories(hit.get_source().getVolumeInfo().getCategories());
        book.setPublisher(hit.get_source().getVolumeInfo().getPublisher());
        book.setPublishedDate(hit.get_source().getVolumeInfo().getPublishedDate());
        book.setTitle(hit.get_source().getVolumeInfo().getTitle());
        book.setSubtitle(hit.get_source().getVolumeInfo().getSubtitle());
        book.setLanguage(hit.get_source().getVolumeInfo().getLanguage());
        return book;
    }
}
