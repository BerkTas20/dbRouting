package com.berktas.dbRouting.master.book.controller;

import com.berktas.dbRouting.master.book.requests.SaveBookRequest;
import com.berktas.dbRouting.master.book.requests.UpdateBookRequest;
import com.berktas.dbRouting.master.book.entity.Book;
import com.berktas.dbRouting.master.book.service.BookManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookManager bookManager;
    
    @PostMapping("/create")
    public Book insertBook(@RequestBody SaveBookRequest request) {
        return bookManager.createBook(request);
    }

    @PostMapping("/{bookId}/create_database")
    public void createDatabase(@PathVariable String bookId) {
        bookManager.createBookDatabase(bookId);
    }

    @PutMapping("/{bookId}/update")
    public Book updateBook(@PathVariable String bookId, @RequestBody UpdateBookRequest request) {
        return bookManager.updateBook(bookId, request);
    }

    @GetMapping("/{bookId}/get")
    public Book getBookById(@PathVariable String bookId) {
        return bookManager.getBookById(bookId);
    }

    @GetMapping("/is_exists")
    public Boolean isBookExists(@RequestParam String code) {
        return bookManager.bookExistsByCode(code);
    }

    @DeleteMapping("/{bookId}/delete")
    public void deleteBook(@PathVariable String bookId) {
        bookManager.deleteBook(bookId);
    }
}
