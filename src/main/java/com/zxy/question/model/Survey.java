package com.zxy.question.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "survey")
public class Survey implements Serializable {
    private static final long serialVersionUID = 2346210645304593676L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String surveyTitle;
    private String surveyDetail;
    private String status;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    
    @OneToMany
    private List<Question> questions;
    
    private Date createTime;
    private Date updateTime;
    private Date expiredTime;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getSurveyTitle() {
        return surveyTitle;
    }
    public void setSurveyTitle(String surveyTitle) {
        this.surveyTitle = surveyTitle;
    }
    public String getSurveyDetail() {
        return surveyDetail;
    }
    public void setSurveyDetail(String surveyDetail) {
        this.surveyDetail = surveyDetail;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
    public List<Question> getQuestions() {
        return questions;
    }
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Date getExpiredTime() {
        return expiredTime;
    }
    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }
    
    
}
