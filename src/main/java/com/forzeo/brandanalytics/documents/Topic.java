package com.forzeo.brandanalytics.documents;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.forzeo.brandanalytics.ApiConstants;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = ApiConstants.TOPICS_COLLECTION)
public class Topic {

    @Id
    private String id;

    private String title;

    private List<String> domainIds;

    private List<String> categoryIds;

    private boolean active;

    
}
