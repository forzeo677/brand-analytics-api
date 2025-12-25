package com.forzeo.brandanalytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableAspectJAutoProxy
@SpringBootApplication
@ComponentScan(basePackages = "com.forzeo.brandanalytics")
@EnableMongoRepositories(basePackages = "com.forzeo.brandanalytics")
public class BrandanalyticsApplication {
    public static void main(String[] args) {
        SpringApplication.run(BrandanalyticsApplication.class, args);
    }
}
