package com.onedata.library.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;

import java.util.Date;

public class BookDto {
    private Long book_id;

    private String author;
    
    private String title;

    private Long isbn;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date registered_date;
    @Min(value = 0,message = "copies must be 0 or greater")
    private Long available_copies;

    public BookDto(Long bookId, String author, Long isbn, String title, Date registeredDate,Long available_copies) {
        this.book_id=bookId;
        this.title=title;
        this.isbn=isbn;
        this.registered_date=registeredDate;
        this.author=author;
        this.available_copies=available_copies;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Date getRegistered_date() {
        return registered_date;
    }

    public void setRegistered_date(Date registered_date) {
        this.registered_date = registered_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAvailable_copies() {
        return available_copies;
    }

    public void setAvailable_copies(Long available_copies) {
        this.available_copies = available_copies;
    }
}
