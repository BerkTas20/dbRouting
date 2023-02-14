package com.berktas.dbRouting.master.init;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DbInitializer implements CommandLineRunner {
    private final DataSource masterDataSource;
    public DbInitializer(@Qualifier("masterDataSource") DataSource masterDataSource ) {
        this.masterDataSource = masterDataSource;
    }
    @Override
    public void run(String... args) throws Exception {

    }
}