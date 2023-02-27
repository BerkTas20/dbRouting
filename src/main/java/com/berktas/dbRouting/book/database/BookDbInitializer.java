package com.berktas.dbRouting.book.database;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@RequiredArgsConstructor
public class BookDbInitializer {
    private final DbSettings dbSettings;

    public void init(String dbName) {
        DataSource dataSource = createDatasource(dbName);
        LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionFactoryBuilder.setProperty("hibernate.hbm2ddl.auto", "update");
        sessionFactoryBuilder.setProperty("hibernate.hbm2ddl.create_namespaces", "true");
        sessionFactoryBuilder.setProperty("hibernate.show_sql", "true");
        sessionFactoryBuilder.setProperty("logging.level.org.hibernate.SQL", "warning");
        sessionFactoryBuilder.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
        sessionFactoryBuilder.setProperty("hibernate.c3p0.min_size", "5");
        sessionFactoryBuilder.setProperty("hibernate.c3p0.max_size", "20");
        sessionFactoryBuilder.setProperty("hibernate.c3p0.acquire_increment", "5");
        sessionFactoryBuilder.setProperty("hibernate.c3p0.timeout", "60");
        sessionFactoryBuilder.setProperty("serverTimezone", "Europe/Istanbul");
        sessionFactoryBuilder.setProperty("AllowPublicKeyRetrieval", "false");
        sessionFactoryBuilder.scanPackages("com.berktas.dbRouting.book");
        sessionFactoryBuilder.setImplicitNamingStrategy(new ImplicitNamingStrategyComponentPathImpl());
        sessionFactoryBuilder.setPhysicalNamingStrategy(new PhysicalNamingStrategyStandardImpl());
        sessionFactoryBuilder.buildSessionFactory().openSession().close();
    }

    private DataSource createDatasource(@NonNull String dbName) {
        return DataSourceBuilder.create()
                .username(dbSettings.getUsername())
                .password(dbSettings.getPassword())
                .url(dbSettings.getBookDatabaseName()
                        .concat(dbName)
                        .concat("?createDatabaseIfNotExist=true"))
                .build();
    }
}
