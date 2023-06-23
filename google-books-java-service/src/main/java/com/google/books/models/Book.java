package com.google.books.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    private String id;
    private String title;
    private String subtitle;
    private List<String> authors = new ArrayList<String>();;
    private String publisher;
    private String publishedDate;
    private String description;
    private List<String> categories = new ArrayList<String>();
    private String language;

}
