package com.forzeo.brandanalytics.utility;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BrandAnalyticsLLMRepository {

    private final MongoTemplate mongoTemplate;

    public BrandAnalyticsLLMRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public BrandAnalyticsLLMDocument save(BrandAnalyticsLLMDocument document) {
        return mongoTemplate.save(document);
    }
}