package com.forzeo.brandanalytics.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.forzeo.brandanalytics.documents.PromptDocument;
import com.forzeo.brandanalytics.documents.TopicAggregateDocument;
import com.forzeo.brandanalytics.documents.User;
import com.forzeo.brandanalytics.dto.BrandPresenceByTopicDTO;
import com.forzeo.brandanalytics.repository.TopicRepository;
import com.forzeo.brandanalytics.repository.UserRepository;

@Service
public class TopicService {

    private final UserRepository userRepository;
    private final TopicRepository topicRepository;

    public TopicService(UserRepository userRepository,
                        TopicRepository topicRepository) {
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
    }

    public List<BrandPresenceByTopicDTO> getTopicsForUser(String userId) {
    	
    
        User user = userRepository.findActiveUserByUserId(userId);

        if (user == null) {
            return Collections.emptyList();
        }

        List<BrandPresenceByTopicDTO>  topicsList = topicRepository.findBrandPresenceByTopic(
                user.getDomains(),
                user.getCategories()
        );
        
        return topicsList;
    }
    
    
    public Map<String, Object> getPromptsByTopic(String topicId) {

        // 1. Fetch aggregated topic + prompts (single DB call)
        TopicAggregateDocument topicAggregate =
        		topicRepository.fetchTopicWithPrompts(topicId);

        if (topicAggregate == null) {
            throw new RuntimeException("Topic not found or inactive");
        }

        // 2. Transform prompts into API response format
        List<Map<String, Object>> promptResults = new ArrayList<>();
       
        for (PromptDocument prompt : topicAggregate.getPrompts()) {

            Map<String, Object> promptMap = new LinkedHashMap<>();
            promptMap.put("prompt_id", prompt.getId());
            promptMap.put("prompt_text", prompt.getText());

            // 3. Hardcoded platform visibility (intentionally)
            promptMap.put("platform_visibiity", Map.of(
                    "chatgpt", Map.of(
                            "status", "present",
                            "rank", "1/21",
                            "sentiment", "neutral"
                    )
            ));

            promptResults.add(promptMap);
        }

        // 4. Build final response object
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("topic_id", topicAggregate.getTopicId());
        response.put("topic_name", topicAggregate.getTopicName());
        response.put("prompt_results", promptResults);

        return response;
    
}

    
    
}
