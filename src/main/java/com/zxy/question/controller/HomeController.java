package com.zxy.question.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zxy.question.model.vo.StatusVO;
import com.zxy.question.model.vo.UserVO;
import com.zxy.question.service.SurveyService;
import com.zxy.question.service.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private SurveyService surveyService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserVO getHomeUser(@PathVariable("id") int id) throws Exception {
        UserVO userVO = userService.findById(id);
        return userVO;
    }
    
    @RequestMapping(value = "/status/{id}", method = RequestMethod.GET)
    public StatusVO getAllStatus(@PathVariable("id") int id) throws Exception {
        StatusVO statusVO = surveyService.findAllStatus(id);
        return statusVO;
    }
}
