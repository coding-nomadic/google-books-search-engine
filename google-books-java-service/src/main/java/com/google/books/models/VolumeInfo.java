package com.google.books.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VolumeInfo {
    private String title;
    private String subtitle;
    private List<String> authors = new ArrayList<String>();
    private String publisher;
    private String publishedDate;
    private String description;
    private List<IndustryIdentifier> industryIdentifiers = new ArrayList<IndustryIdentifier>();
    private ReadingModes readingModes;
    private Integer pageCount;
    private String printType;
    private List<String> categories = new ArrayList<String>();
    private Double averageRating;
    private Integer ratingsCount;
    private String maturityRating;
    private Boolean allowAnonLogging;
    private String contentVersion;
    private PanelizationSummary panelizationSummary;
    private ImageLinks imageLinks;
    private String language;
    private String previewLink;
    private String infoLink;
    private String canonicalVolumeLink;
}
