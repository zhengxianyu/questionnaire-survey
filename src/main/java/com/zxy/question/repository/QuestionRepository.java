package com.zxy.question.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.zxy.question.model.Question;
import com.zxy.question.model.Survey;

public interface QuestionRepository extends CrudRepository<Question, String> {

    @Query("select question from Question question where"
            + " question.survey=?1 and question.expiredTime=null")
    List<Question> findAllQuestions(Survey survey);

    @Query("select question from Question question where question.id=?1 and question.expiredTime=null")
    Question findById(int question_id);

    @Modifying
    @Query("update Question question set question.expiredTime=now() where question.id=?1")
    Integer deleteQuestion(int question_id);

    @Query("select count(*) from Question question where question.survey=?1 and question.type=?2 and question.expiredTime=null")
    int findByType(Survey survey, String type);

}
