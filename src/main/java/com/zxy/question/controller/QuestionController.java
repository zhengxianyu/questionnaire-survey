package com.zxy.question.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zxy.question.model.vo.QuestionVO;
import com.zxy.question.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public QuestionVO createQuestion(@PathVariable("id") int id, @RequestBody QuestionVO questionVO) throws Exception {
        QuestionVO newQuestionVO = questionService.createOrUpdateQuestion(id, questionVO);
        return newQuestionVO;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public QuestionVO updateQuestion(@PathVariable("id") int id, @RequestBody QuestionVO questionVO) throws Exception {
        QuestionVO newQuestionVO = questionService.createOrUpdateQuestion(id, questionVO);
        return newQuestionVO;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Integer deleteQuestion(@PathVariable("id") int question_id) throws Exception {
        Integer success = questionService.deleteQuestion(question_id);
        return success;
    }
}
