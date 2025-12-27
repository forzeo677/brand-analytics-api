package com.forzeo.brandanalytics.utility;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "prompt_responses_llm")
public class BrandAnalyticsLLMDocument {

	private String promptId;
    private String topicId;
    private String promptText;
    private String source;
    private String model;

    private Map<String, Object> rawResponse;

    private List<BrandDetected> brandsDetected;

	
}
