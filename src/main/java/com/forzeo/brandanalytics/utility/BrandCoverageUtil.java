package com.forzeo.brandanalytics.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BrandCoverageUtil {

    private static final Pattern BRAND_SECTION_PATTERN =
            Pattern.compile(
                    "\\*\\*(.*?)\\*\\*[\\s\\S]*?(?=\\n###|\\Z)",
                    Pattern.MULTILINE
            );

    public static int countBrandSectionWords(String markdown, String brandName) {

        Matcher matcher = BRAND_SECTION_PATTERN.matcher(markdown);

        while (matcher.find()) {
            String section = matcher.group();
            if (section.contains("**" + brandName + "**")) {
                return countWords(section);
            }
        }
        return 0;
    }

    public static int countAllBrandsWords(String markdown) {

        Matcher matcher = BRAND_SECTION_PATTERN.matcher(markdown);
        int total = 0;

        while (matcher.find()) {
            total += countWords(matcher.group());
        }
        return total;
    }

    private static int countWords(String text) {
        return text.trim().split("\\s+").length;
    }
}
