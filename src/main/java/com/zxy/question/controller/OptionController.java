package com.zxy.question.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zxy.question.model.vo.SubmitVO;
import com.zxy.question.service.OptionService;

@RestController
@RequestMapping("/option")
public class OptionController {
    @Autowired
    private OptionService optionService;
    
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public SubmitVO submitOptions(@RequestBody SubmitVO submitVO) throws Exception {
        optionService.submitOptions(submitVO);
        return submitVO;
    }
}
