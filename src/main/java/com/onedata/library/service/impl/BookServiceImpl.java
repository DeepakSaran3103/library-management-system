package com.onedata.library.service.impl;

import com.onedata.library.entities.BookEntities;
import com.onedata.library.exceptions.InvalidException;
import com.onedata.library.mapper.Mapper;
import com.onedata.library.dto.BookDto;
import com.onedata.library.repository.BookRepository;
import com.onedata.library.service.intterface.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public  BookDto addBook(BookDto bookdto){
        BookEntities bookEntitie= Mapper.mapBook(bookdto);
         BookEntities bookEntities1= bookRepository.save(bookEntitie);
        return Mapper.mapBookDto(bookEntities1);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        BookDto bookDto1=findById(bookDto.getBook_id());
        return addBook(bookDto);

    }

    @Override
    public void deleteBook(Long id) {
        BookDto bookDto=findById(id);
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto findById(Long id) {
        if(bookRepository.findById(id).isEmpty()){
            throw new InvalidException("No Book have been found!!!");
        }
        BookEntities bookEntities = bookRepository.findById(id).get();
        return Mapper.mapBookDto(bookEntities);
    }

    @Override
    public List<BookDto> findByTitle(String value){
        List<BookEntities> bookEntitiesList =bookRepository.findByTitle(value);
        if(bookEntitiesList.isEmpty()){
            throw new InvalidException(String.format("List of Books is not available for the title: %s", value));
        }
        return Mapper.bookDotList(bookEntitiesList);
    }

    @Override
    public List<BookDto> findByAuthor(String value){
        List<BookEntities> bookEntitiesList=bookRepository.findByAuthor(value);
        if(bookEntitiesList.isEmpty()){
            throw new InvalidException(String.format("List of Books is not available for the author: %s", value));
        }
        return Mapper.bookDotList(bookEntitiesList);
    }

    @Override
    public List<BookDto> findByIsbn(Long value){
        List<BookEntities> bookEntitiesList=bookRepository.findByIsbn(value);
        if(bookEntitiesList.isEmpty()){
            throw new InvalidException(String.format("List of Books is not available for the isbn: %d", value));
        }
        return Mapper.bookDotList(bookEntitiesList);
    }

}
