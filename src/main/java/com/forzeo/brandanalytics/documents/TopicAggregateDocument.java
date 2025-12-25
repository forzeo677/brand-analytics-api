package com.forzeo.brandanalytics.documents;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TopicAggregateDocument {

    @Id
    private String topicId;

    private String topicName;

    private List<PromptDocument> prompts;

    
}