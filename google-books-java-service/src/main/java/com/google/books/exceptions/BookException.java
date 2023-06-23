package com.google.books.exceptions;


public class BookException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final String code;

    public BookException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}