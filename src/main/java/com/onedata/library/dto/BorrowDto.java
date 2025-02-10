package com.onedata.library.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BorrowDto {
    private Long id;
    private Long bookid;
    private Long membersid;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date borrowed_date;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date due_date;


    public BorrowDto(Long bookid, Date borrowed_date, Date due_date, Long id, Long memberid) {
        this.bookid=bookid;
        this.membersid=memberid;
        this.borrowed_date = borrowed_date;
        this.due_date = due_date;
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public Long getMembersid() {
        return membersid;
    }

    public void setMembersid(Long membersid) {
        this.membersid = membersid;
    }

}
