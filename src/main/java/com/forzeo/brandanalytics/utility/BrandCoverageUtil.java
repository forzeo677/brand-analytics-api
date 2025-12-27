package com.forzeo.brandanalytics.utility;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BrandCoverageUtil {

	public static int countBrandSectionWords(String markdown, String brandName) {

	    String brandBlock = extractFullBrandBlock(markdown, brandName);
	    return countWords(brandBlock);
	}

	private static String extractFullBrandBlock(String markdown, String brandName) {

	    Pattern pattern = Pattern.compile(
	            "\\*\\*" + Pattern.quote(brandName) + "\\*\\*([\\s\\S]*?)(?=\\n###|$)",
	            Pattern.CASE_INSENSITIVE
	    );

	    Matcher matcher = pattern.matcher(markdown);
	    return matcher.find() ? matcher.group(1) : "";
	}

	public static int countAllBrandsWords(String markdown) {

	    int total = 0;

	    Map<String, Integer> brands =
	            BrandParserLLMUtil.extractBrandMentions(markdown);

	    for (String brand : brands.keySet()) {
	        total += countBrandSectionWords(markdown, brand);
	    }

	    return total;
	}


   

    private static int countWords(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }
        return text.trim().split("\\s+").length;
    }

}
