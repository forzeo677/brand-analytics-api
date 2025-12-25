package com.forzeo.brandanalytics.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.forzeo.brandanalytics.ApiConstants;
import com.forzeo.brandanalytics.dto.BrandPresenceByTopicDTO;
import com.forzeo.brandanalytics.services.TopicService;

@RestController
@RequestMapping(ApiConstants.TOPICS_MAPPING)

public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/user")
    public ResponseEntity<List<BrandPresenceByTopicDTO>> getTopicsForUser(
            @RequestParam(name = "userId",
                          defaultValue = ApiConstants.DEFAULT_USER_ID)
            String userId) {

        return ResponseEntity.ok(topicService.getTopicsForUser(userId));
    }

    
    
    @PostMapping("/prompts")
    public ResponseEntity<Map<String, Object>> getPrompts(
            @RequestBody Map<String, String> request) {

        return ResponseEntity.ok(
        		topicService.getPromptsByTopic(request.get("topic_id"))
        );
    }
}
