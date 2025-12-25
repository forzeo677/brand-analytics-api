package com.forzeo.brandanalytics.controller;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	 private final MongoTemplate mongoTemplate;

	    public HelloController(MongoTemplate mongoTemplate) {
	        this.mongoTemplate = mongoTemplate;
	    }

	
    @GetMapping("/hello")
    public String hello() {
        return "Spring Boot is running!";
    }
    
    
    
   
    @GetMapping("/mongo-test")
    public String testMongo() {
        mongoTemplate.getDb().runCommand(new org.bson.Document("ping", 1));
        return "MongoDB Atlas connected successfully";
    }
}