package com.forzeo.brandanalytics.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.forzeo.brandanalytics.ApiConstants;
import com.forzeo.brandanalytics.documents.User;

@Repository
public class UserRepository {

    private final MongoTemplate mongoTemplate;

    public UserRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public User findActiveUserByUserId(String userId) {

        Query query = new Query(
                Criteria.where("userId").is(userId)
                     
        );

        return mongoTemplate.findOne(query, User.class, ApiConstants.USERS_COLLECTION);
    }
    
  
}
