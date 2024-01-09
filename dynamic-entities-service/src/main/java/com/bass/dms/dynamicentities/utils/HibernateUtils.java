package com.bass.dms.dynamicentities.utils;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.File;

@Configuration
@EnableTransactionManagement
public class HibernateUtils {

    @Value("${db.driver}")
    private String DRIVER;

    @Value("${db.password}")
    private String PASSWORD;

    @Value("${db.url}")
    private String URL;

    @Value("${db.username}")
    private String USERNAME;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    @Bean(name = {"sessionFactory", "entityManagerFactory"})
    public SessionFactory sessionFactory() {
        SessionFactory sessionFactory = null;
        try {
            //Create the configuration object.
            org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
            //Initialize the configuration object
            //with the configuration file data
            configuration.configure("hibernate.cfg.xml");
            // Get the SessionFactory object from configuration.
            sessionFactory = new org.hibernate.cfg.Configuration().addDirectory(new File("./")).configure().buildSessionFactory();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }

}



