package com.zxy.question.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aoption")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String optionName;
    private String type;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;
    
    private int chooseTimes;
    private Date createTime;
    private Date expiredTime;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getOptionName() {
        return optionName;
    }
    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Question getQuestion() {
        return question;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }
    
    public int getChooseTimes() {
        return chooseTimes;
    }
    public void setChooseTimes(int chooseTimes) {
        this.chooseTimes = chooseTimes;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getExpiredTime() {
        return expiredTime;
    }
    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

}
