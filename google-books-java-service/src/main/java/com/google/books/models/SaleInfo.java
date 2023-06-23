package com.google.books.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaleInfo {
    private String country;
    private String saleability;
    private Boolean isEbook;
}
