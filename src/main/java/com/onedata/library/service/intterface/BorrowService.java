package com.onedata.library.service.intterface;

import com.onedata.library.dto.BorrowDto;
import org.springframework.stereotype.Service;

@Service
public interface BorrowService  {
    BorrowDto addBorrow(BorrowDto BorrowDto);
    BorrowDto updateBorrow(BorrowDto BorrowDto);
    void deleteBorrow(Long id);
}
