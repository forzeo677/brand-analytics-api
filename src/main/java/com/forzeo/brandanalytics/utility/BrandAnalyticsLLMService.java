package com.forzeo.brandanalytics.utility;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class BrandAnalyticsLLMService {

    private final BrandAnalyticsLLMRepository repository;

    public BrandAnalyticsLLMService(BrandAnalyticsLLMRepository repository) {
        this.repository = repository;
    }

    public BrandAnalyticsLLMDocument process(
            String promptId,
            String topicId,
            String promptText,
            Map<String, Object> rawResponse) {

        String markdown = extractMarkdown(rawResponse);

        Map<String, Integer> brandMentions =
                BrandParserLLMUtil.extractBrandMentions(markdown);

        int maxBrandsPresent = brandMentions.size();

        int totalBrandWords =
                BrandCoverageUtil.countAllBrandsWords(markdown);

        List<BrandDetected> detected = brandMentions.entrySet().stream()
                .map(entry -> buildBrand(
                        entry.getKey(),
                        entry.getValue(),
                        maxBrandsPresent,
                        markdown,
                        totalBrandWords
                ))
                .collect(Collectors.toList());

        BrandAnalyticsLLMDocument document = new BrandAnalyticsLLMDocument();
        document.setPromptId(promptId);
        document.setTopicId(topicId);
        document.setPromptText(promptText);
        document.setSource("llm");
        document.setModel("gpt-5-2");
        document.setRawResponse(rawResponse);
        document.setBrandsDetected(detected);

        return repository.save(document);
    }

    @SuppressWarnings("unchecked")
    private String extractMarkdown(Map<String, Object> rawResponse) {

        List<Map<String, Object>> results =
                (List<Map<String, Object>>) rawResponse.get("result");

        Map<String, Object> firstResult = results.get(0);

        List<Map<String, Object>> items =
                (List<Map<String, Object>>) firstResult.get("items");

        return (String) items.get(0).get("markdown");
    }

    private BrandDetected buildBrand(
            String brandName,
            int brandMentions,
            int maxBrandsPresent,
            String markdown,
            int totalBrandWords
    ) {

        // ---------- Mention Score ----------
        MentionScore mentionScore = new MentionScore();
        mentionScore.setBrandMentions(brandMentions);
        mentionScore.setMaxBrandsPresent(maxBrandsPresent);
        mentionScore.setFinalScore(
                maxBrandsPresent == 0
                        ? 0.0
                        : (brandMentions * 100.0) / maxBrandsPresent
        );

        // ---------- Answer Coverage ----------
        int currentBrandWords =
                BrandCoverageUtil.countBrandSectionWords(markdown, brandName);

        AnswerCoverage answerCoverage = new AnswerCoverage();
        answerCoverage.setCurrentbrandwords(currentBrandWords);
        answerCoverage.setTotalbrandWords(totalBrandWords);
        answerCoverage.setFinalScore(
                totalBrandWords == 0
                        ? 0.0
                        : (currentBrandWords * 100.0) / totalBrandWords
        );

        // ---------- Visibility Score ----------
        VisibilityScore visibilityScore = new VisibilityScore();
        visibilityScore.setMentionScore(mentionScore);
        visibilityScore.setAnswerCoverage(answerCoverage);

        // ---------- BrandDetected ----------
        BrandDetected detected = new BrandDetected();
        detected.setBrandName(brandName);
        detected.setVisibilityScore(visibilityScore);

        return detected;
    }
}
