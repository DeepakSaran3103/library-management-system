package com.onedata.library.controler;

import com.onedata.library.dto.BookDto;
import com.onedata.library.exceptions.InvalidException;
import com.onedata.library.service.intterface.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("add")
    public ResponseEntity<Object> addBook(@RequestBody @Valid BookDto bookDto, BindingResult result) {

        if (result.hasErrors()) {
            String errorMessage = result.getFieldErrors()

                    .stream()
                    .map(error -> error.getField() + " " + error.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
        if (String.valueOf(bookDto.getIsbn()).length() != 10 && String.valueOf(bookDto.getIsbn()).length() != 13) {
            throw new InvalidException("ISBN number must be exactly 10 or 13 digits");
        }
        BookDto saved = bookService.addBook(bookDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    @PostMapping("update")
    public ResponseEntity<BookDto> update (@RequestBody BookDto bookDto){
        BookDto saved = bookService.updateBook(bookDto);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book Details was Deleted");
    }

    @GetMapping("title/{value}")
    public ResponseEntity<List<BookDto>> title (@PathVariable("value") String value){
        return new ResponseEntity<>(bookService.findByTitle(value),HttpStatus.OK);
    }
    @GetMapping("author/{value}")
    public ResponseEntity<List<BookDto>> author (@PathVariable("value") String value){
        return new ResponseEntity<>(bookService.findByAuthor(value),HttpStatus.OK);
    }
    @GetMapping("isbn/{value}")
    public ResponseEntity<List<BookDto>> isbn (@PathVariable("value") Long value){
        String str=String.valueOf(value);
        if (str.length() != 10 && str.length() != 13) {
            throw new InvalidException("ISBN number must be exactly 10 or 13 digits");
        }
        return new ResponseEntity<>(bookService.findByIsbn(value),HttpStatus.OK);
    }
}
