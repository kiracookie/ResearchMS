package com.cookie.kira.researchms.entity;

import java.util.List;

/**
 * Created by 11669 on 2017-06-29.
 */

public class Paper {
    private int id;
    private String name;
    private List<Question> questions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
