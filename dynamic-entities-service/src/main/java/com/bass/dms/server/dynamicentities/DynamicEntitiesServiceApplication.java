package com.bass.dms.server.dynamicentities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class DynamicEntitiesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicEntitiesServiceApplication.class, args);
    }

}
