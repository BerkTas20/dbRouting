package com.berktas.dbRouting.master.book.repository;

import com.berktas.dbRouting.master.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, String> {
    Boolean existsByCode(String code);

    Optional<Book> findByCode(String book);
}
