/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab6.filme2.config;

import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author José Nicodemos Maia Neto<jose at nicomaia.com.br>
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories({"com.lab6.filme2.dao"})
public class JPAPersistenseConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.lab6.filme2.model");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    @Bean
    public DataSource dataSource() {
        
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/fatec_filmes");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }

    Properties additionalProperties() {
        
        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.connection.autocommit", "false");

        return properties;
    }

    @Bean
    public EntityManager entityManager(EntityManagerFactory emf) {
        
        return emf.createEntityManager();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }
    
//    @Bean
//    public LocalSessionFactoryBean sessionFactory(PlatformTransactionManager transactionManager) {
//        
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan("com.lab6.filme2.model");
//        sessionFactory.setHibernateProperties(additionalProperties());
//        
//        return sessionFactory;
//    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
