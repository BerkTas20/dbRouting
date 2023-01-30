package com.berktas.dbRouting.book.service;

import com.berktas.dbRouting.book.controller.requests.SaveBookRequest;
import com.berktas.dbRouting.book.controller.requests.UpdateBookRequest;
import com.berktas.dbRouting.book.database.BookDbInitializer;
import com.berktas.dbRouting.book.database.DataSourceRouting;
import com.berktas.dbRouting.book.database.DbSettings;
import com.berktas.dbRouting.book.entity.Book;
import com.berktas.dbRouting.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookManager {
    private final BookRepository bookRepository;
    private final BookDbInitializer bookDbInitializer;
    private final DbSettings dbSettings;

    private final DataSourceRouting dataSourceRouting;

    public void createBookDatabase(String bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(RuntimeException::new);
        try {
            bookDbInitializer.init(book.getDbName());
            dataSourceRouting.execute(book);
        } catch (Exception e) {
            log.warn("exception", e);
        }
    }
    public Book createBook(SaveBookRequest request) {
        Book book = bookRepository.save(Book.create(request, dbSettings.getDbNamePrefix()));
        createBookDatabase(book.getId());
        return book;
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public Book getBookById(String bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("User not found by id: " + bookId));
    }

    public Book updateBook(String id, UpdateBookRequest request) {
        Book school = bookRepository
                .findById(id).orElseThrow(() -> new RuntimeException("User not found by id: " + id));
        return bookRepository.save(school.update(request));
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    public Boolean bookExistsByCode(String code) {
        return bookRepository.existsByCode(code);
    }

}
