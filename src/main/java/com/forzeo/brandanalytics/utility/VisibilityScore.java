package com.forzeo.brandanalytics.utility;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VisibilityScore {

    private MentionScore mentionScore;
    private AnswerCoverage answerCoverage;

}
