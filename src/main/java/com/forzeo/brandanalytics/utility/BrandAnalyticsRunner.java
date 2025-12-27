package com.forzeo.brandanalytics.utility;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class BrandAnalyticsRunner implements CommandLineRunner {

    private final BrandAnalyticsLLMService service;
    private final ObjectMapper objectMapper;

    public BrandAnalyticsRunner(BrandAnalyticsLLMService service,
                                ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {

     
        String promptId = "prompt_005";
        String topicId = "cricket_match_analysis";
        String prompText = "Which websites provide the most detailed post-match cricket analysis and breakdown";
        String rawJson = "{\r\n"
        		+ "  \"id\": \"12271316-1269-0629-0000-325f6a0a283f\",\r\n"
        		+ "  \"status_code\": 20000,\r\n"
        		+ "  \"status_message\": \"Ok.\",\r\n"
        		+ "  \"time\": \"47.0549 sec.\",\r\n"
        		+ "  \"cost\": 0.004,\r\n"
        		+ "  \"result_count\": 1,\r\n"
        		+ "  \"path\": [\r\n"
        		+ "    \"v3\",\r\n"
        		+ "    \"ai_optimization\",\r\n"
        		+ "    \"chat_gpt\",\r\n"
        		+ "    \"llm_scraper\",\r\n"
        		+ "    \"live\",\r\n"
        		+ "    \"advanced\"\r\n"
        		+ "  ],\r\n"
        		+ "  \"data\": {\r\n"
        		+ "    \"api\": \"ai_optimization\",\r\n"
        		+ "    \"function\": \"llm_scraper\",\r\n"
        		+ "    \"se\": \"chat_gpt\",\r\n"
        		+ "    \"keyword\": \"Which websites provide the most detailed post-match cricket analysis and breakdown\",\r\n"
        		+ "    \"language_code\": \"en\",\r\n"
        		+ "    \"location_code\": 2840,\r\n"
        		+ "    \"force_web_search\": false,\r\n"
        		+ "    \"postback_data\": \"advanced\",\r\n"
        		+ "    \"device\": \"desktop\",\r\n"
        		+ "    \"os\": \"windows\"\r\n"
        		+ "  },\r\n"
        		+ "  \"result\": [\r\n"
        		+ "    {\r\n"
        		+ "      \"keyword\": \"Which websites provide the most detailed post-match cricket analysis and breakdown\",\r\n"
        		+ "      \"location_code\": 2840,\r\n"
        		+ "      \"language_code\": \"en\",\r\n"
        		+ "      \"model\": \"gpt-5-2\",\r\n"
        		+ "      \"check_url\": \"https://chatgpt.com/?prompt=Which%20websites%20provide%20the%20most%20detailed%20post-match%20cricket%20analysis%20and%20breakdown\",\r\n"
        		+ "      \"datetime\": \"2025-12-27 11:17:02 +00:00\",\r\n"
        		+ "      \"markdown\": \"For detailed post-match cricket analysis and breakdowns, here are some of the best websites and platforms where you can get in-depth insights, stats, and expert opinions:\\n\\n### 1. **ESPNcricinfo**  \\n   - **Website**: [www.espncricinfo.com](https://www.espncricinfo.com)\\n   - **What it offers**:  \\n     ESPNcricinfo is widely regarded as the go-to site for cricket analysis. It offers detailed match reports, player stats, and expert commentary. Post-match analysis often includes tactical breakdowns, interviews with players, and expert columns. The \\\"Match Centre\\\" and \\\"Analysis\\\" sections provide deep dives into specific aspects of the match.\\n   - **Key Features**:  \\n     - Player and team stats\\n     - Expert columns and match reviews\\n     - Detailed scorecards and video highlights\\n\\n### 2. **Cricbuzz**  \\n   - **Website**: [www.cricbuzz.com](https://www.cricbuzz.com)\\n   - **What it offers**:  \\n     Cricbuzz is another major platform that provides match summaries, statistical analysis, and tactical breakdowns. It often has live blogs with minute-by-minute updates during matches and extensive post-match analyses. Cricbuzz’s \\\"Match Summary\\\" and \\\"Player of the Match\\\" sections are detailed and provide insight into what worked and what didn’t for both teams.\\n   - **Key Features**:  \\n     - Live match coverage with detailed commentary\\n     - Post-match expert analysis\\n     - In-depth stats and breakdowns\\n\\n### 3. **The Cricket Monthly (by ESPNcricinfo)**  \\n   - **Website**: [www.espncricinfo.com/the-cricket-monthly](https://www.espncricinfo.com/the-cricket-monthly)\\n   - **What it offers**:  \\n     This monthly publication offers comprehensive features, in-depth articles, and long-form analysis on various cricketing issues. It dives deep into technical aspects of the game, historical context, and player strategies.\\n   - **Key Features**:  \\n     - Deep dives into tactical trends\\n     - Interviews and profiles\\n     - Special reports on individual players or specific series\\n\\n### 4. **Wisden**  \\n   - **Website**: [www.wisden.com](https://www.wisden.com)\\n   - **What it offers**:  \\n     Wisden provides a rich historical perspective on cricket along with detailed match reports, stats, and player analysis. Their post-match coverage includes analysis of key moments, tactical decisions, and overall performances.\\n   - **Key Features**:  \\n     - Expert match reports and analysis\\n     - Historical context in current match reviews\\n     - Special focus on statistics\\n\\n### 5. **Cricingif**  \\n   - **Website**: [www.cricingif.com](https://www.cricingif.com)\\n   - **What it offers**:  \\n     Cricingif is known for its live ball-by-ball coverage, match highlights, and post-match analyses. They also have animated scorecards and shot-by-shot analysis, which help break down match moments in great detail.\\n   - **Key Features**:  \\n     - Ball-by-ball animated match analysis\\n     - Tactical breakdowns and match highlights\\n     - Statistical insights and visuals\\n\\n### 6. **Cricket Australia (Official)**  \\n   - **Website**: [www.cricket.com.au](https://www.cricket.com.au)\\n   - **What it offers**:  \\n     Cricket Australia’s website features post-match analysis, player interviews, and detailed reviews of international games. It also offers team and player breakdowns, along with expert commentary and tactical insights.\\n   - **Key Features**:  \\n     - Post-match reports and analysis\\n     - Player and team statistics\\n     - Tactical insights from experts\\n\\n### 7. **The Cricket Paper**  \\n   - **Website**: [www.thecricketpaper.com](https://www.thecricketpaper.com)\\n   - **What it offers**:  \\n     A more niche publication, The Cricket Paper focuses on post-match analysis, expert columns, and in-depth match reviews. It’s especially useful for detailed analysis of English county cricket and international series.\\n   - **Key Features**:  \\n     - Match reports and tactical analysis\\n     - Columns from former players and experts\\n     - In-depth reviews and opinion pieces\\n\\n### 8. **BBC Sport - Cricket**  \\n   - **Website**: [www.bbc.com/sport/cricket](https://www.bbc.com/sport/cricket)\\n   - **What it offers**:  \\n     BBC Sport offers detailed post-match summaries, player ratings, and tactical breakdowns. It often includes highlights and expert opinions, particularly on major international tournaments.\\n   - **Key Features**:  \\n     - Live match commentary and reports\\n     - Post-match breakdowns and analysis\\n     - Player and team statistics\\n\\n### 9. **Sky Sports Cricket**  \\n   - **Website**: [www.skysports.com/cricket](https://www.skysports.com/cricket)\\n   - **What it offers**:  \\n     Sky Sports provides post-match analysis and expert commentary, especially during big international tournaments and series. Their analysis often includes video breakdowns of key moments and player performances.\\n   - **Key Features**:  \\n     - In-depth match reviews\\n     - Player analysis and tactical breakdowns\\n     - Video highlights and key moments\\n\\n### 10. **The Guardian - Cricket**  \\n   - **Website**: [www.theguardian.com/sport/cricket](https://www.theguardian.com/sport/cricket)\\n   - **What it offers**:  \\n     The Guardian offers high-quality analysis and match reviews, focusing on both technical aspects and the broader context of the game. Their post-match articles often explore key decisions and turning points in the match.\\n   - **Key Features**:  \\n     - In-depth tactical analysis\\n     - Expert opinions and match summaries\\n     - Statistical insights and context\\n\\n### 11. **YouTube Channels** (for Video Analysis)  \\n   - **CricBuzz Live**\\n   - **ESPNcricinfo (Video)**\\n   - **Sky Sports Cricket (Video)**  \\n   These channels offer detailed post-match analysis in video form, often breaking down key moments, discussing strategies, and analyzing performances with former players and experts.\\n\\n### 12. **Reddit - Cricket Subreddits**\\n   - **Website**: [www.reddit.com/r/cricket](https://www.reddit.com/r/cricket)\\n   - **What it offers**:  \\n     While not a professional site, the r/cricket subreddit provides great community-driven analysis. Fans and experts alike discuss and break down matches in great detail. You can find discussions on tactics, player performances, and match decisions that offer a different perspective from official reports.\\n\\nThese websites and platforms are excellent sources for understanding what happened in a match, why it happened, and what it means for the future. Whether you're into stats, tactical analysis, or expert commentary, there's a resource for every type of cricket fan!\",\r\n"
        		+ "      \"search_results\": null,\r\n"
        		+ "      \"sources\": null,\r\n"
        		+ "      \"fan_out_queries\": null,\r\n"
        		+ "      \"brand_entities\": null,\r\n"
        		+ "      \"se_results_count\": 0,\r\n"
        		+ "      \"item_types\": [\r\n"
        		+ "        \"chat_gpt_text\"\r\n"
        		+ "      ],\r\n"
        		+ "      \"items_count\": 1,\r\n"
        		+ "      \"items\": [\r\n"
        		+ "        {\r\n"
        		+ "          \"type\": \"chat_gpt_text\",\r\n"
        		+ "          \"rank_group\": 1,\r\n"
        		+ "          \"rank_absolute\": 1,\r\n"
        		+ "          \"markdown\": \"For detailed post-match cricket analysis and breakdowns, here are some of the best websites and platforms where you can get in-depth insights, stats, and expert opinions:\\n\\n### 1. **ESPNcricinfo**  \\n   - **Website**: [www.espncricinfo.com](https://www.espncricinfo.com)\\n   - **What it offers**:  \\n     ESPNcricinfo is widely regarded as the go-to site for cricket analysis. It offers detailed match reports, player stats, and expert commentary. Post-match analysis often includes tactical breakdowns, interviews with players, and expert columns. The \\\"Match Centre\\\" and \\\"Analysis\\\" sections provide deep dives into specific aspects of the match.\\n   - **Key Features**:  \\n     - Player and team stats\\n     - Expert columns and match reviews\\n     - Detailed scorecards and video highlights\\n\\n### 2. **Cricbuzz**  \\n   - **Website**: [www.cricbuzz.com](https://www.cricbuzz.com)\\n   - **What it offers**:  \\n     Cricbuzz is another major platform that provides match summaries, statistical analysis, and tactical breakdowns. It often has live blogs with minute-by-minute updates during matches and extensive post-match analyses. Cricbuzz’s \\\"Match Summary\\\" and \\\"Player of the Match\\\" sections are detailed and provide insight into what worked and what didn’t for both teams.\\n   - **Key Features**:  \\n     - Live match coverage with detailed commentary\\n     - Post-match expert analysis\\n     - In-depth stats and breakdowns\\n\\n### 3. **The Cricket Monthly (by ESPNcricinfo)**  \\n   - **Website**: [www.espncricinfo.com/the-cricket-monthly](https://www.espncricinfo.com/the-cricket-monthly)\\n   - **What it offers**:  \\n     This monthly publication offers comprehensive features, in-depth articles, and long-form analysis on various cricketing issues. It dives deep into technical aspects of the game, historical context, and player strategies.\\n   - **Key Features**:  \\n     - Deep dives into tactical trends\\n     - Interviews and profiles\\n     - Special reports on individual players or specific series\\n\\n### 4. **Wisden**  \\n   - **Website**: [www.wisden.com](https://www.wisden.com)\\n   - **What it offers**:  \\n     Wisden provides a rich historical perspective on cricket along with detailed match reports, stats, and player analysis. Their post-match coverage includes analysis of key moments, tactical decisions, and overall performances.\\n   - **Key Features**:  \\n     - Expert match reports and analysis\\n     - Historical context in current match reviews\\n     - Special focus on statistics\\n\\n### 5. **Cricingif**  \\n   - **Website**: [www.cricingif.com](https://www.cricingif.com)\\n   - **What it offers**:  \\n     Cricingif is known for its live ball-by-ball coverage, match highlights, and post-match analyses. They also have animated scorecards and shot-by-shot analysis, which help break down match moments in great detail.\\n   - **Key Features**:  \\n     - Ball-by-ball animated match analysis\\n     - Tactical breakdowns and match highlights\\n     - Statistical insights and visuals\\n\\n### 6. **Cricket Australia (Official)**  \\n   - **Website**: [www.cricket.com.au](https://www.cricket.com.au)\\n   - **What it offers**:  \\n     Cricket Australia’s website features post-match analysis, player interviews, and detailed reviews of international games. It also offers team and player breakdowns, along with expert commentary and tactical insights.\\n   - **Key Features**:  \\n     - Post-match reports and analysis\\n     - Player and team statistics\\n     - Tactical insights from experts\\n\\n### 7. **The Cricket Paper**  \\n   - **Website**: [www.thecricketpaper.com](https://www.thecricketpaper.com)\\n   - **What it offers**:  \\n     A more niche publication, The Cricket Paper focuses on post-match analysis, expert columns, and in-depth match reviews. It’s especially useful for detailed analysis of English county cricket and international series.\\n   - **Key Features**:  \\n     - Match reports and tactical analysis\\n     - Columns from former players and experts\\n     - In-depth reviews and opinion pieces\\n\\n### 8. **BBC Sport - Cricket**  \\n   - **Website**: [www.bbc.com/sport/cricket](https://www.bbc.com/sport/cricket)\\n   - **What it offers**:  \\n     BBC Sport offers detailed post-match summaries, player ratings, and tactical breakdowns. It often includes highlights and expert opinions, particularly on major international tournaments.\\n   - **Key Features**:  \\n     - Live match commentary and reports\\n     - Post-match breakdowns and analysis\\n     - Player and team statistics\\n\\n### 9. **Sky Sports Cricket**  \\n   - **Website**: [www.skysports.com/cricket](https://www.skysports.com/cricket)\\n   - **What it offers**:  \\n     Sky Sports provides post-match analysis and expert commentary, especially during big international tournaments and series. Their analysis often includes video breakdowns of key moments and player performances.\\n   - **Key Features**:  \\n     - In-depth match reviews\\n     - Player analysis and tactical breakdowns\\n     - Video highlights and key moments\\n\\n### 10. **The Guardian - Cricket**  \\n   - **Website**: [www.theguardian.com/sport/cricket](https://www.theguardian.com/sport/cricket)\\n   - **What it offers**:  \\n     The Guardian offers high-quality analysis and match reviews, focusing on both technical aspects and the broader context of the game. Their post-match articles often explore key decisions and turning points in the match.\\n   - **Key Features**:  \\n     - In-depth tactical analysis\\n     - Expert opinions and match summaries\\n     - Statistical insights and context\\n\\n### 11. **YouTube Channels** (for Video Analysis)  \\n   - **CricBuzz Live**\\n   - **ESPNcricinfo (Video)**\\n   - **Sky Sports Cricket (Video)**  \\n   These channels offer detailed post-match analysis in video form, often breaking down key moments, discussing strategies, and analyzing performances with former players and experts.\\n\\n### 12. **Reddit - Cricket Subreddits**\\n   - **Website**: [www.reddit.com/r/cricket](https://www.reddit.com/r/cricket)\\n   - **What it offers**:  \\n     While not a professional site, the r/cricket subreddit provides great community-driven analysis. Fans and experts alike discuss and break down matches in great detail. You can find discussions on tactics, player performances, and match decisions that offer a different perspective from official reports.\\n\\nThese websites and platforms are excellent sources for understanding what happened in a match, why it happened, and what it means for the future. Whether you're into stats, tactical analysis, or expert commentary, there's a resource for every type of cricket fan!\",\r\n"
        		+ "          \"sources\": null,\r\n"
        		+ "          \"brand_entities\": null\r\n"
        		+ "        }\r\n"
        		+ "      ]\r\n"
        		+ "    }\r\n"
        		+ "  ]\r\n"
        		+ "}";        
        Map<String, Object> rawResponse =
                objectMapper.readValue(
                        rawJson,
                        new TypeReference<Map<String, Object>>() {});
        
        
        BrandAnalyticsLLMDocument document =
                service.process(promptId, topicId, prompText , rawResponse);

        System.out.println(
                objectMapper.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(document)
        );
    }
}
