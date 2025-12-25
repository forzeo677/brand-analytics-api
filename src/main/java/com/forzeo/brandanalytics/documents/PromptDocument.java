package com.forzeo.brandanalytics.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "prompts")
public class PromptDocument {

    @Id
    private String id;

    private String topicId;
    private String text;
    private Boolean active;


}
