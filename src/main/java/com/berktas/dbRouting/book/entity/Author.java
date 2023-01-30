package com.berktas.dbRouting.book.entity;

import com.berktas.dbRouting.book.controller.requests.SaveAuthorRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "UK_USER_NAME"),
        @UniqueConstraint(columnNames = "email", name = "UK_USER_EMAIL")
})
public class Author {
    @Id
    @Column(nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String email;

    public static Author create(SaveAuthorRequest request) {
        Author student = new Author();
        student.setEmail(request.getEmail());
        student.setName(request.getName());
        return student;
    }

}
