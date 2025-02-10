package com.onedata.library.mapper;

import com.onedata.library.entities.BookEntities;
import com.onedata.library.entities.BorrowEntities;
import com.onedata.library.entities.MemberEntities;
import com.onedata.library.dto.BookDto;
import com.onedata.library.dto.BorrowDto;
import com.onedata.library.dto.MemberDto;
import com.onedata.library.exceptions.InvalidException;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static BookDto mapBookDto(BookEntities bookEntities){
        return new BookDto(bookEntities.getBook_id(),bookEntities.getAuthor(),bookEntities.getIsbn(),bookEntities.getTitle(),bookEntities.getRegistered_date(),bookEntities.getAvailable_copies());
    }
    public static BookEntities mapBook(BookDto bookDto){
        return new BookEntities(bookDto.getBook_id(),bookDto.getAuthor(),bookDto.getIsbn(),bookDto.getTitle(),bookDto.getRegistered_date(),bookDto.getAvailable_copies());
    }
    public static BorrowDto mapBorrowDto(BorrowEntities borrowEntities){
        return new BorrowDto(borrowEntities.getBook_id().getBook_id(),borrowEntities.getBorrowed_date(),borrowEntities.getDue_date(),borrowEntities.getId(),borrowEntities.getMember_id().getMember_id());
    }
    public static BorrowEntities mapBorrow(BorrowDto borrowDto,BookEntities bookEntities,MemberEntities memberEntities){
        return new BorrowEntities(bookEntities,borrowDto.getBorrowed_date(),borrowDto.getDue_date(),borrowDto.getId(),memberEntities);
    }
    public static MemberDto mapMemberDto(MemberEntities memberEntities){
        return new MemberDto(memberEntities.getMember_id(),memberEntities.getName(),memberEntities.getPhone_number(),memberEntities.getRegistered_date());
    }
    public static MemberEntities mapMember(MemberDto memberDto){
        return new MemberEntities(memberDto.getMember_id(),memberDto.getName(),memberDto.getPhone_number(),memberDto.getRegistered_date());
    }
    public static List<BookDto> bookDotList(List<BookEntities> bookEntitiesList){
        List<BookDto> bookDtoArrayList=new ArrayList<>();
        for(BookEntities bookEntities:bookEntitiesList){
            bookDtoArrayList.add(Mapper.mapBookDto(bookEntities));
        }
        return bookDtoArrayList;
    }
}
