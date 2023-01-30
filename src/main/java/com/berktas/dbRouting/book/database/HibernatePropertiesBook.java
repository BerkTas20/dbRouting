package com.berktas.dbRouting.book.database;

import org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;

import java.util.HashMap;
import java.util.Map;

public class HibernatePropertiesBook {
    public static Map<String, Object> get() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");

        properties.put("hibernate.show_sql", "true");
        properties.put("logging.level.org.hibernate.SQL", "warning");
        properties.put("spring.jpa.hibernate.c3p0.min_size", "5");
        properties.put("spring.jpa.hibernate.c3p0.max_size", "20");
        properties.put("spring.jpa.hibernate.c3p0.acquire_increment", "5");
        properties.put("spring.jpa.hibernate.c3p0.timeout", "60");
        properties.put("serverTimezone", "Europe/Istanbul");
        properties.put("AllowPublicKeyRetrieval", "false");


        properties.put("hibernate.naming.physical-strategy", PhysicalNamingStrategyStandardImpl.class.getName());
        properties.put("hibernate.naming.implicit-strategy", ImplicitNamingStrategyComponentPathImpl.class.getName());

        properties.put("hibernate.physical_naming_strategy", PhysicalNamingStrategyStandardImpl.class.getName());
        properties.put("hibernate.implicit_naming_strategy", ImplicitNamingStrategyComponentPathImpl.class.getName());

        properties.put("spring.jpa.hibernate.naming.physical-strategy", PhysicalNamingStrategyStandardImpl.class.getName());
        properties.put("spring.jpa.hibernate.naming.implicit-strategy", ImplicitNamingStrategyComponentPathImpl.class.getName());

        return properties;
    }
}
