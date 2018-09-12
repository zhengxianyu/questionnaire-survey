package com.zxy.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zxy.question.model.vo.SurveyVO;
import com.zxy.question.service.SurveyService;

@RestController
@RequestMapping("/survey")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    //获取所有问卷，使用GET请求
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<SurveyVO> getSurveys(@PathVariable("id") int userId, String type, String search_value) throws Exception {
        List<SurveyVO> surveyVOs = surveyService.getAllSurveys(userId, type, search_value);
        return surveyVOs;
    }

    //创建问卷，使用POST请求
    @RequestMapping(method = RequestMethod.POST)
    public SurveyVO createSurvey(@RequestBody SurveyVO surveyVO) throws Exception {
        surveyService.createOrUpdateSurvey(surveyVO);
        return surveyVO;
    }
    
    //更新问卷，使用PUT请求
    @RequestMapping(method = RequestMethod.PUT)
    public SurveyVO updateSurvey(@RequestBody SurveyVO surveyVO) 
            throws Exception {
        surveyService.createOrUpdateSurvey(surveyVO);
        return surveyVO;
    }
    
    //删除问卷，使用DELETE请求
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Integer deleteSurvey(@PathVariable("id") int id) throws Exception {
        Integer success = surveyService.deleteSurvey(id);
        return success;
    }
    
    //接下来是surveyDetail代码
    //得到问卷详情页面信息，使用GET请求
    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public SurveyVO getSurvey(@PathVariable("id") int surveyId) throws Exception {
        SurveyVO surveyVO = surveyService.getSurvey(surveyId);
        return surveyVO;
    }
    
    //改变问卷状态，使用PATCH请求
    @RequestMapping(value = "/{id}/{status}", method = RequestMethod.PATCH)
    public Integer changeType(@PathVariable("id") int surveyId
            , @PathVariable("status") String surveyStatus) throws Exception {
        Integer success = surveyService.changeStatus(surveyId, surveyStatus);
        return success;
    }
}
