package com.onedata.library.controler;

import com.onedata.library.dto.BorrowDto;
import com.onedata.library.exceptions.InvalidException;
import com.onedata.library.mapper.Mapper;
import com.onedata.library.service.intterface.BorrowService;
import com.onedata.library.service.intterface.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.onedata.library.service.intterface.BookService;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
    private final BorrowService borrowService;
    @Autowired
    private BookService bookService;
    @Autowired
    private MemberService memberService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @PostMapping("add")
    public ResponseEntity<BorrowDto> addBorrow(@RequestBody BorrowDto borrowDto) {
        BorrowDto saved = borrowService.addBorrow(borrowDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    @PostMapping("update")
    public ResponseEntity<BorrowDto> update (@RequestBody BorrowDto borrowDto){
        BorrowDto saved = borrowService.updateBorrow(borrowDto);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        borrowService.deleteBorrow(id);
        return ResponseEntity.ok("Borrow Details was Deleted");
    }
}
