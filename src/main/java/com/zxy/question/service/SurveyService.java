package com.zxy.question.service;

import java.util.List;

import com.zxy.question.model.vo.StatusVO;
import com.zxy.question.model.vo.SurveyVO;

public interface SurveyService {

    void createOrUpdateSurvey(SurveyVO surveyVO);

    List<SurveyVO> getAllSurveys(int userId, String search_value, String search_value2);

    Integer deleteSurvey(int id);

    SurveyVO getSurvey(int surveyId);

    Integer changeStatus(int surveyId, String surveyStatus);

    StatusVO findAllStatus(int id);

}
