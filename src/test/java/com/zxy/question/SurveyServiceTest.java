package com.zxy.question;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.zxy.question.model.vo.SurveyVO;
import com.zxy.question.service.SurveyService;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持
@SpringBootTest(classes=QuestionnaireSurveyApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration
public class SurveyServiceTest {
    @Autowired
    private SurveyService surveyService;

    //@Test
    public void getSurveys() {
        int id = 1;
        String type="save";
        String search_value = "kody";
        List<SurveyVO> surveyVOs = surveyService.getAllSurveys(id, type, search_value);
        System.out.println(surveyVOs);
    }
    
    //@Test
    public void createSurvey() {
        SurveyVO surveyVO = new SurveyVO();
        surveyVO.setSponsor("kody");
        surveyVO.setSurveyTitle("vivien");
        surveyVO.setSurveyDetail("best");
        surveyService.createOrUpdateSurvey(surveyVO);
        System.out.println(surveyVO);
    }
    
    //@Test
    public void updateSurvey() {
        SurveyVO surveyVO = new SurveyVO();
        surveyVO.setKey(1);
        surveyVO.setSponsor("kody");
        surveyVO.setSurveyTitle("vivien");
        surveyVO.setSurveyDetail("best man");
        surveyService.createOrUpdateSurvey(surveyVO);
        System.out.println(surveyVO);
    }
    
    //@Test
    public void deleteSurvey() {
        int id = 1;
        Integer success = surveyService.deleteSurvey(id);
        System.out.println(success);
    }
    
    //@Test
    public void getSurvey() {
        int surveyId = 1;
        SurveyVO surveyVO = surveyService.getSurvey(surveyId);
        System.out.println("success:"+surveyVO);
    }
    
    @Test
    public void changeType() throws Exception {
        int surveyId = 1;
        String surveyStatus = "creating";
        Integer success = surveyService.changeStatus(surveyId, surveyStatus);
        System.out.println("success:"+success);
    }
}
