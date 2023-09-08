package com.google.books.utils;

import com.google.books.configs.AppConfig;
import org.springframework.web.util.UriComponentsBuilder;

public final class UrlBuilderUtils {

    private UrlBuilderUtils() {
        // Private constructor to prevent instantiation
    }

    public static String getSearchBook(AppConfig appConfig, String title) {
        return UriComponentsBuilder.newInstance()
                .scheme(appConfig.elasticSearchDetails().getElasticProtocol())
                .host(appConfig.elasticSearchDetails().getElasticUrl())
                .port(appConfig.elasticSearchDetails().getElasticPort())
                .path(appConfig.elasticSearchDetails().getIndexName() + "/")
                .path("_search")
                .queryParam("q", "title=" + title)
                .build()
                .toString();
    }

    public static String getAllBooks(AppConfig appConfig) {
        return UriComponentsBuilder.newInstance()
                .scheme(appConfig.elasticSearchDetails().getElasticProtocol())
                .host(appConfig.elasticSearchDetails().getElasticUrl())
                .port(appConfig.elasticSearchDetails().getElasticPort())
                .path(appConfig.elasticSearchDetails().getIndexName() + "/")
                .path("_search")
                .build()
                .toString();
    }
}
