package com.zxy.question.service;

import com.zxy.question.model.vo.QuestionVO;

public interface QuestionService {

    QuestionVO createOrUpdateQuestion(int id, QuestionVO questionVO);

    Integer deleteQuestion(int question_id);

    

}
