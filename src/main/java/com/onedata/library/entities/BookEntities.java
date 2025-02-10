package com.onedata.library.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.util.Date;

@Entity
@Table(name = "book")
public class BookEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;

    @Column
    private String author;

    @Column
    private String title;

    @Column
    private Long isbn;

    @Column
    private Date registered_date;

    @Column
    @Min(value =0)
    private Long available_copies;

    public BookEntities(Long bookId, String author, Long isbn, String title, Date registeredDate,Long available_copies) {
        this.book_id=bookId;
        this.title=title;
        this.isbn=isbn;
        this.registered_date=registeredDate;
        this.author=author;
        this.available_copies=available_copies;
    }

    public BookEntities() {
    }

    public Long getBook_id() {

        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Long getAvailable_copies() {
        return available_copies;
    }

    public void setAvailable_copies(Long available_copies) {
        this.available_copies = available_copies;
    }

    public void setRegistered_date(Date registered_date) {
        this.registered_date = registered_date;
    }
}
