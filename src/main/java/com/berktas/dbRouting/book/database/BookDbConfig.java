package com.berktas.dbRouting.book.database;

import lombok.RequiredArgsConstructor;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.berktas.dbRouting.book",
        entityManagerFactoryRef = "bookEntityManagerFactory",
        transactionManagerRef = "bookTransactionManager"
)
@RequiredArgsConstructor
public class BookDbConfig {
    private final DataSourceRouting dataSourceRouting;
    @Bean
    public LocalContainerEntityManagerFactoryBean bookEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSourceRouting);
        em.setPackagesToScan("com.berktas.dbRouting.book");
        em.setPersistenceProvider(new HibernatePersistenceProvider());
        em.setJpaPropertyMap(HibernatePropertiesBook.get());
        return em;
    }

    @Bean
    public PlatformTransactionManager bookTransactionManager(@Qualifier("bookEntityManagerFactory") final EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }
}
