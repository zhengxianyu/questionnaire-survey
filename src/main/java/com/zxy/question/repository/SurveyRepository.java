package com.zxy.question.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.zxy.question.model.Survey;
import com.zxy.question.model.User;

public interface SurveyRepository extends CrudRepository<Survey, String> {
    
    @Query("select survey from Survey survey where survey.user=?1")
    List<Survey> findAllSurveys(User user);

    @Query("select survey from Survey survey where survey.id=?1")
    Survey findById(int id);

    @Query("select survey from Survey survey where survey.user=?1 "
            + "and survey.surveyTitle like %?2%")
    List<Survey> findSearchSurveys(User user, String search_value);

    @Modifying
    @Query("update Survey survey set survey.status='stop', survey.expiredTime=now() where survey.id=?1")
    Integer deleteSurvey(int id);

    @Modifying
    @Query("update Survey survey set survey.status=?2 where survey.id=?1")
    Integer changeStatus(int surveyId, String surveyStatus);

    @Query("select count(*) from Survey survey where survey.user=?1 and survey.status=?2")
    int countCreating(User user, String status);

    @Query("select survey from Survey survey where survey.user=?1 and survey.status=?2")
    List<Survey> findSurveysByType(User user, String type);

    @Query("select survey from Survey survey where survey.user=?1 and survey.status=?2 "
            + "and survey.surveyTitle like %?3%")
    List<Survey> findSearchSurveys(User user, String type, String search_value);

}
