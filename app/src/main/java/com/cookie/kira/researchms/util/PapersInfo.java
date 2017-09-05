package com.cookie.kira.researchms.util;

import com.cookie.kira.researchms.entity.Option;
import com.cookie.kira.researchms.entity.Paper;
import com.cookie.kira.researchms.entity.Question;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 11669 on 2017-09-05.
 * 试卷信息
 */

public class PapersInfo {

    String papers = "[{\"id\":\"1\",\"name\":\"paper1\"},{\"id\":\"2\",\"name\":\"paper2\"}]";
    String quesions = "[{\"paperId\":\"1\",\"id\":\"1\",\"text\":\"1_1\",\"type\":\"1\",\"comment\":\"1_1_comment\"},{\"paperId\":\"1\",\"id\":\"2\",\"text\":\"1_2\",\"type\":\"2\",\"comment\":\"1_2_comment\"}]";
    String options = "[{\"id\":\"1\",\"questionId\":\"1\",\"paperId\":\"1\",\"text\":\"1_1_1_option\",\"value\":\"1\"},{\"id\":\"2\",\"questionId\":\"1\",\"paperId\":\"1\",\"text\":\"1_1_2_option\",\"value\":\"2\"}]";

    Map<Integer, Paper> paperMap;

    /*初始化试卷信息*/
    public PapersInfo() {
        Gson gson = new Gson();

        paperMap = new LinkedHashMap<>();
        List<Paper> paperList = gson.fromJson(papers,
                new TypeToken<List<Paper>>() {
                }.getType());
        List<Question> questionList = gson.fromJson(quesions,
                new TypeToken<List<Question>>() {
                }.getType());
        List<Option> optionList = gson.fromJson(options,
                new TypeToken<List<Option>>() {
                }.getType());

        for (Paper paper : paperList) {
            paper.setQuestions(new ArrayList<Question>());
            for (Question question : questionList) {
                question.setOptions(new ArrayList<Option>());
                for (Option option : optionList) {
                    if (option.getQuestionId() == question.getId())
                        question.getOptions().add(option);
                }
                if (question.getPaperId() == paper.getId())
                    paper.getQuestions().add(question);
            }
            paperMap.put(paper.getId(), paper);
        }
    }

    public String getPapers() {
        return papers;
    }

    public void setPapers(String papers) {
        this.papers = papers;
    }

    public String getQuesions() {
        return quesions;
    }

    public void setQuesions(String quesions) {
        this.quesions = quesions;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Map<Integer, Paper> getPaperMap() {
        return paperMap;
    }

    public void setPaperMap(Map<Integer, Paper> paperMap) {
        this.paperMap = paperMap;
    }
}
