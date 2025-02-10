package com.onedata.library.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "member")
public class MemberEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    @Column
    private String name;

    @Column
    private Long phone_number;

    @Column
    private Date registered_date;

    public Long getMember_id() {
        return member_id;
    }

    public MemberEntities(Long member_id, String name, Long phone_number, Date registered_date) {
        this.member_id = member_id;
        this.name = name;
        this.phone_number = phone_number;
        this.registered_date = registered_date;
    }

    public MemberEntities() {
    }

    public void setMember_id(Long member_id) {
        this.member_id = member_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }

    public Date getRegistered_date() {
        return registered_date;
    }

    public void setRegistered_date(Date registered_date) {
        this.registered_date = registered_date;
    }
}
