package com.zxy.question.model.vo;

import java.util.List;

public class QuestionVO {
    private int id;
    private String questionTitle;
    private String type;
    private List<OptionVO> optionVOs;
    private int allSelectTimes;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getQuestionTitle() {
        return questionTitle;
    }
    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public List<OptionVO> getOptionVOs() {
        return optionVOs;
    }
    public void setOptionVOs(List<OptionVO> optionVOs) {
        this.optionVOs = optionVOs;
    }
    public String getA() {
        return a;
    }
    public void setA(String a) {
        this.a = a;
    }
    public String getB() {
        return b;
    }
    public void setB(String b) {
        this.b = b;
    }
    public String getC() {
        return c;
    }
    public void setC(String c) {
        this.c = c;
    }
    public String getD() {
        return d;
    }
    public void setD(String d) {
        this.d = d;
    }
    public String getE() {
        return e;
    }
    public void setE(String e) {
        this.e = e;
    }
    public String getF() {
        return f;
    }
    public void setF(String f) {
        this.f = f;
    }
    public String getG() {
        return g;
    }
    public void setG(String g) {
        this.g = g;
    }
    public String getH() {
        return h;
    }
    public void setH(String h) {
        this.h = h;
    }
    public int getAllSelectTimes() {
        return allSelectTimes;
    }
    public void setAllSelectTimes(int allSelectTimes) {
        this.allSelectTimes = allSelectTimes;
    }
   
}
