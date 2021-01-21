package com.afei.config.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {



    @Autowired
    DbDomain dbDomain;

    @Bean
    @ConfigurationProperties(prefix = "mengWangBalance")
    public DbDomain getDbDomian(){

        return  dbDomain;
    }
}
