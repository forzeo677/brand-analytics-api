package com.forzeo.brandanalytics.utility;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BrandParserLLMUtil {

	private static final Pattern BRAND_PATTERN =
	        Pattern.compile(
	            "###\\s*(\\d+)\\.\\s*\\*\\*(.*?)\\*\\*"
	        );
	public static Map<String, Integer> extractBrandMentions(String markdown) {

	    Map<String, Integer> brandCount = new LinkedHashMap<>();
	    Matcher matcher = BRAND_PATTERN.matcher(markdown);

	    while (matcher.find()) {
	        int index = Integer.parseInt(matcher.group(1));

	        // STRICTLY stop at top 10 brands
	        if (index > 10) {
	            break;
	        }

	        String brand = matcher.group(2).trim();
	        brandCount.put(brand, 1); // one entry per brand
	    }

	    return brandCount;
	}

    private static String normalize(String brand) {
        return brand
                .replaceAll("\\(.*?\\)", "") // remove aliases
                .trim();
    }
}
