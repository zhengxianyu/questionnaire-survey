package com.zxy.question;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.zxy.question.model.vo.QuestionVO;
import com.zxy.question.service.QuestionService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=QuestionnaireSurveyApplication.class)
@WebAppConfiguration
public class QuestionServiceTest {
    @Autowired
    private QuestionService questionService;

    @Test
    public void createQuestion() throws Exception {
        int id = 1;
        QuestionVO questionVO = new QuestionVO();
        questionVO.setType("completion");
        questionVO.setQuestionTitle("test create");
        QuestionVO newQuestionVO = questionService.createOrUpdateQuestion(id, questionVO);
        System.out.println(newQuestionVO);
    }
    
    //@Test
    public void updateQuestion() {
        int id = 1;
        QuestionVO questionVO = new QuestionVO();
        questionVO.setType("completion");
        questionVO.setQuestionTitle("test update");
        QuestionVO newQuestionVO = questionService.createOrUpdateQuestion(id, questionVO);
        System.out.println(newQuestionVO);
    }
    
    //@Test
    public void deleteQuestion() throws Exception {
        int question_id = 1;
        Integer success = questionService.deleteQuestion(question_id);
        System.out.println(success);
    }
}
