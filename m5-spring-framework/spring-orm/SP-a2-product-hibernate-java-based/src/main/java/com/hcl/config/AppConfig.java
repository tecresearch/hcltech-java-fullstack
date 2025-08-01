package com.hcl.config;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.hcl")
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springmvc12?createDatabaseIfNotExist=true");
        dataSource.setUsername("tecresearch");
        dataSource.setPassword("Tca@admin");
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.hcl.model");
        sessionFactory.getHibernateProperties().put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        sessionFactory.getHibernateProperties().put("hibernate.hbm2ddl.auto", "update");
        sessionFactory.getHibernateProperties().put("hibernate.show_sql", "true");
        return sessionFactory;
    }
}