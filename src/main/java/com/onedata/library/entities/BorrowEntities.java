package com.onedata.library.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "borrow")
public class BorrowEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id") // Foreign key column for BookEntities
    private BookEntities book_id;

    @ManyToOne
    @JoinColumn(name = "memberid") // Foreign key column for MemberEntities
    private MemberEntities member_id;

    @Column
    private Date borrowed_date;

    @Column
    private Date due_date;

    public BorrowEntities() {
    }

    public BorrowEntities(BookEntities book_id, Date borrowed_date, Date due_date, Long id, MemberEntities member_id) {
        this.book_id = book_id;
        this.borrowed_date = borrowed_date;
        this.due_date = due_date;
        this.id = id;
        this.member_id = member_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookEntities getBook_id() {
        return book_id;
    }

    public void setBook_id(BookEntities book_id) {
        this.book_id = book_id;
    }

    public MemberEntities getMember_id() {
        return member_id;
    }

    public void setMember_id(MemberEntities member_id) {
        this.member_id = member_id;
    }

    public Date getBorrowed_date() {
        return borrowed_date;
    }

    public void setBorrowed_date(Date borrowed_date) {
        this.borrowed_date = borrowed_date;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }
}
