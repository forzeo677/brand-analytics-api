package com.forzeo.brandanalytics.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BrandPresenceByTopicDTO {

    private String topicId;
    private String topicName;
    private int promptCount;

    
}
