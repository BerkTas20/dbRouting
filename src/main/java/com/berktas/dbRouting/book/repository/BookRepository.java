package com.berktas.dbRouting.book.repository;

import com.berktas.dbRouting.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, String> {
    Boolean existsByCode(String code);

    Optional<Book> findByCode(String book);
}
