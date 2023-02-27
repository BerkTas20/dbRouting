package com.berktas.dbRouting.book.service;

import com.berktas.dbRouting.book.controller.requests.SaveAuthorRequest;
import com.berktas.dbRouting.book.entity.Author;
import com.berktas.dbRouting.book.repository.AuthorRepository;
import com.berktas.dbRouting.book.database.DataSourceRouting;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorManager {
    private final AuthorRepository authorRepository;
    private final DataSourceRouting dataSourceRouting;

    public Author createAuthor(SaveAuthorRequest request) {
        dataSourceRouting.setDbName(request.getDbName());
        dataSourceRouting.determineTargetDataSource();
        return authorRepository.save(Author.create(request));
    }
}
