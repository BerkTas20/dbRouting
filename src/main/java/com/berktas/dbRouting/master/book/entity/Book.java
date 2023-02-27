package com.berktas.dbRouting.master.book.entity;

import com.berktas.dbRouting.master.book.requests.UpdateBookRequest;
import com.berktas.dbRouting.master.book.requests.SaveBookRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "dbName", name = "UK_BOOK_DB_NAME"),
})
public class Book {
    @Id
    @Column(nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(nullable = false)
    private String dbName;

    private String code;

    private String title;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    @PrePersist
    protected void onCreate() {
        updatedAt = createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @PreRemove
    protected void onDelete() {
        deletedAt = LocalDateTime.now();
    }


    public static Book create(SaveBookRequest request, String dbNamePrefix) {
        Book book = new Book();
        book.code = request.getCode();
        book.title = request.getTitle();
        book.dbName = dbNamePrefix.concat(request.getDbName());
        return book;
    }

    public Book update(UpdateBookRequest request) {
        Book book = this;
        book.code = request.getCode();
        book.title = request.getTitle();
        return book;
    }

}
