package com.bass.dms.server.dynamicentities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@EnableFeignClients
public class DynamicEntitiesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicEntitiesServiceApplication.class, args);
    }

}
