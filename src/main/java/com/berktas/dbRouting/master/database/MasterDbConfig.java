package com.berktas.dbRouting.master.database;

import com.berktas.dbRouting.book.database.DbSettings;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.berktas.dbRouting.master",
        entityManagerFactoryRef = "masterEntityManager",
        transactionManagerRef = "masterTransactionManager"
)
@RequiredArgsConstructor
public class MasterDbConfig {
    private final DbSettings dbSettings;
    @Bean
    public LocalContainerEntityManagerFactoryBean masterEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(masterDataSource());
        em.setPackagesToScan(
                "com.berktas.dbRouting.master");

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaPropertyMap(HibernatePropertiesMaster.get());

        return em;
    }

    @Bean("masterDataSource")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create()
                .username(dbSettings.getUsername())
                .password(dbSettings.getPassword())
                .url(dbSettings.getDbUrl() + dbSettings.getMasterDatabaseName() + "?createDatabaseIfNotExist=true")
                .build();
    }

    @Bean
    public PlatformTransactionManager masterTransactionManager() {
        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                masterEntityManager().getObject());
        return transactionManager;
    }
}