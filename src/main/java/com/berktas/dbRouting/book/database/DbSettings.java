package com.berktas.dbRouting.book.database;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Getter
@Setter
@Primary
@Configuration
public class DbSettings {
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${db.setting.url}")
    private String masterDatabaseName;
    @Value("${spring.datasource.db_prefix}")
    private String dbNamePrefix;
    @Value("${spring.datasource.db_postfix}")
    private String dbNamePostfix;
    @Value("${spring.datasource.url}")
    private String bookDatabaseName;

}
