package com.cookie.kira.researchms.entity;

import java.util.List;
import java.util.Map;

/**
 * Created by 11669 on 2017-07-11.
 */

public class Answer {
    private List<AnswerDetail> answerDetails;
    private Map<String, AnswerDetail> answerDetailsMap;
    private String owner;

    public List<AnswerDetail> getAnswerDetails() {
        return answerDetails;
    }

    public void setAnswerDetails(List<AnswerDetail> answerDetails) {
        this.answerDetails = answerDetails;
        if (!answerDetails.isEmpty()) {
            for (AnswerDetail ad : answerDetails) {
                answerDetailsMap.put(ad.getPaperId() + "_" + ad.getQuestionId() + "_" + ad.getOptionId(), ad);
            }
        }
    }

    public Map<String, AnswerDetail> getAnswerDetailsMap() {
        return answerDetailsMap;
    }

    public void setAnswerDetailsMap(Map<String, AnswerDetail> answerDetailsMap) {
        this.answerDetailsMap = answerDetailsMap;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
