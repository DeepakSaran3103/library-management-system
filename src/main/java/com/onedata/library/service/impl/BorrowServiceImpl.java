package com.onedata.library.service.impl;

import com.onedata.library.entities.BookEntities;
import com.onedata.library.entities.BorrowEntities;
import com.onedata.library.entities.MemberEntities;
import com.onedata.library.exceptions.InvalidException;
import com.onedata.library.mapper.Mapper;
import com.onedata.library.repository.BorrowRepository;
import com.onedata.library.dto.BorrowDto;
import com.onedata.library.service.intterface.BookService;
import com.onedata.library.service.intterface.BorrowService;
import com.onedata.library.service.intterface.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;
    @Autowired
    private BookService bookService;
    @Autowired
    private MemberService memberService;

    @Override
    public BorrowDto addBorrow(BorrowDto borrowDto){
        if(borrowDto.getBorrowed_date()!=null&&borrowDto.getDue_date()!=null){
            throw new InvalidException("Both Borrow date and Due date should not have value at a time");
        }
        BookEntities bookEntities=Mapper.mapBook(bookService.findById(borrowDto.getBookid()));
        if(bookEntities.getAvailable_copies()<=0){
            throw new InvalidException("Book Copies not available");
        }
        if(borrowDto.getBorrowed_date()!=null)
            bookEntities.setAvailable_copies(bookEntities.getAvailable_copies() - 1L);
        if(borrowDto.getDue_date()!=null){
            bookEntities.setAvailable_copies(bookEntities.getAvailable_copies() + 1L);
        }
        bookService.updateBook(Mapper.mapBookDto(bookEntities));
        MemberEntities memberEntities=Mapper.mapMember(memberService.findById(borrowDto.getMembersid()));
        BorrowEntities BorrowEntities= Mapper.mapBorrow(borrowDto,bookEntities,memberEntities);
        BorrowEntities BorrowEntities1=borrowRepository.save(BorrowEntities);
        return Mapper.mapBorrowDto(BorrowEntities1);
    }

    @Override
    public BorrowDto updateBorrow(BorrowDto borrowDto) {

        BorrowDto borrowDto1=findById(borrowDto.getId());
        return addBorrow(borrowDto);

    }

    @Override
    public void deleteBorrow(Long id) {
        BorrowDto BorrowDto=findById(id);
        borrowRepository.deleteById(id);
    }

    public BorrowDto findById(Long id) {
        Optional<BorrowEntities> BorrowEntities=borrowRepository.findById(id);
        BorrowEntities BorrowEntities1=BorrowEntities.get();
        return Mapper.mapBorrowDto(BorrowEntities1);
    }
}
