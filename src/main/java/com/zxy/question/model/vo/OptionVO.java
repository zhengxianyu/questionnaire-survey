package com.zxy.question.model.vo;

import com.zxy.question.model.Question;

public class OptionVO {
    private int id;
    private Question question;
    private String optionName;
    private String value;
    private int selectTimes;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Question getQuestion() {
        return question;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }
    
    public String getOptionName() {
        return optionName;
    }
    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public int getSelectTimes() {
        return selectTimes;
    }
    public void setSelectTimes(int selectTimes) {
        this.selectTimes = selectTimes;
    }
    
}
