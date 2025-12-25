package com.forzeo.brandanalytics.documents;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document(collection = "users")

public class User {

    @Id
    private String id;
    @Field("userId")
    private String userId;
    private List<String> domains;
    private List<String> categories;
    private boolean active;

   
}
