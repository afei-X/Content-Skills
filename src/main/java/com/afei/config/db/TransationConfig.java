package com.afei.config.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
public class TransationConfig {


    /**
     * 配置数据源事物
     * @param dataSource
     * @return
     */
    @Bean
    public PlatformTransactionManager txManage(DataSource dataSource){

        return new DataSourceTransactionManager(dataSource);
    }
}
