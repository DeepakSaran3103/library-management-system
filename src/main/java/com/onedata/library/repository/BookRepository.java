package com.onedata.library.repository;

import com.onedata.library.entities.BookEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntities, Long> {
    @Query(value = "SELECT * FROM book WHERE title = :value", nativeQuery = true)
    List<BookEntities> findByTitle(String value);
    @Query(value = "SELECT * FROM book WHERE author = :value", nativeQuery = true)
        List<BookEntities> findByAuthor(String value);
    @Query(value = "SELECT * FROM book WHERE isbn = :value", nativeQuery = true)
        List<BookEntities> findByIsbn(Long value);
}
