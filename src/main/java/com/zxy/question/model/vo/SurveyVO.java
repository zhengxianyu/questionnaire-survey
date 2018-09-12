package com.zxy.question.model.vo;

import java.util.List;

public class SurveyVO {
    private int key;
    private int userId;
    private String surveyTitle;
    private String surveyDetail;
    private List<QuestionVO> qustionVOs;
    private String sponsor;
    private String status;
    private String statusCh;
    private String time;
    private TypeVO typeVO;
    private String createTime;
    private String expiredTime;
    
    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
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
    
    public List<QuestionVO> getQustionVOs() {
        return qustionVOs;
    }
    public void setQustionVOs(List<QuestionVO> qustionVOs) {
        this.qustionVOs = qustionVOs;
    }
    public String getSponsor() {
        return sponsor;
    }
    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getStatusCh() {
        return statusCh;
    }
    public void setStatusCh(String statusCh) {
        this.statusCh = statusCh;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public TypeVO getTypeVO() {
        return typeVO;
    }
    public void setTypeVO(TypeVO typeVO) {
        this.typeVO = typeVO;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getExpiredTime() {
        return expiredTime;
    }
    public void setExpiredTime(String expiredTime) {
        this.expiredTime = expiredTime;
    }
    
    
    
}
