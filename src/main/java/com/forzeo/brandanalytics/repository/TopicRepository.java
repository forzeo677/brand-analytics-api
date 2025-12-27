package com.forzeo.brandanalytics.repository;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.core.aggregation.ComparisonOperators;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.forzeo.brandanalytics.ApiConstants;
import com.forzeo.brandanalytics.documents.TopicAggregateDocument;
import com.forzeo.brandanalytics.dto.BrandPresenceByTopicDTO;

@Repository
public class TopicRepository {

    private final MongoTemplate mongoTemplate;

    public TopicRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<BrandPresenceByTopicDTO> findBrandPresenceByTopic(
            List<String> domainIds,
            List<String> categoryIds) {

        MatchOperation matchTopics = Aggregation.match(
                Criteria.where(ApiConstants.ACTIVE).is(true)
                        .and(ApiConstants.DOMAIN_IDS).in(domainIds)
                        .and(ApiConstants.CATEGORY_IDS).in(categoryIds)
        );

        LookupOperation lookupPrompts = LookupOperation.newLookup()
                .from(ApiConstants.PROMPTS_COLLECTION)
                .localField("_id")
                .foreignField("topicId")
                .as("prompts");

        ProjectionOperation project = Aggregation.project()
                .and("_id").as("topicId")
                .and("title").as("topicName")
                .and(
                    ArrayOperators.Size.lengthOfArray(
                        ArrayOperators.Filter.filter("prompts")
                            .as("p")
                            .by(
                                ComparisonOperators.Eq.valueOf("$$p.active")
                                    .equalToValue(true)
                            )
                    )
                ).as("promptCount");

        LimitOperation limitStage = Aggregation.limit(10);

        Aggregation aggregation = Aggregation.newAggregation(
                matchTopics,
                lookupPrompts,
                project,
                limitStage
        );

        AggregationResults<BrandPresenceByTopicDTO> results =
                mongoTemplate.aggregate(
                        aggregation,
                        ApiConstants.TOPICS_COLLECTION,
                        BrandPresenceByTopicDTO.class
                );

        return results.getMappedResults();
    }

    
    public TopicAggregateDocument fetchTopicWithPrompts(String topicId) {

        MatchOperation matchTopic = Aggregation.match(
                Criteria.where("_id").is(topicId)
                        .and("active").is(true)
        );

        LookupOperation lookupPrompts = LookupOperation.newLookup()
                .from("prompts")
                .localField("_id")
                .foreignField("topicId")
                .as("prompts");

        ProjectionOperation project = Aggregation.project()
                .and("_id").as("topicId")
                .and("title").as("topicName")
                .and(
                        ArrayOperators.Filter.filter("prompts")
                                .as("prompt")
                                .by(
                                        ComparisonOperators.Eq
                                                .valueOf("$$prompt.active")
                                                .equalToValue(true)
                                )
                ).as("prompts");

        Aggregation aggregation = Aggregation.newAggregation(
                matchTopic,
                lookupPrompts,
                project
        );

        return mongoTemplate.aggregate(
                aggregation,
                "topics",
                TopicAggregateDocument.class
        ).getUniqueMappedResult();
    }
}

    



   

