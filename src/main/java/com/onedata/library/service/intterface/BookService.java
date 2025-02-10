package com.onedata.library.service.intterface;

import com.onedata.library.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    BookDto addBook(BookDto bookDto);
    BookDto updateBook(BookDto bookDto);
    void deleteBook(Long id);
    public List<BookDto> findByTitle(String value);
    public List<BookDto> findByAuthor(String value);
    public List<BookDto> findByIsbn(Long value);
    BookDto findById(Long id);
}
