package com.berktas.dbRouting.book.repository;

import com.berktas.dbRouting.book.entity.Author;
import com.berktas.dbRouting.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, String> {
}
