package com.onedata.library.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

public class MemberDto {
    private Long member_id;
    private String name;
    private Long phone_number;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date registered_date;

    public MemberDto(Long member_id, String name, Long phone_number, Date registered_date) {
        this.member_id = member_id;
        this.name = name;
        this.phone_number = phone_number;
        this.registered_date = registered_date;
    }

    public Long getMember_id() {
        return member_id;
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
