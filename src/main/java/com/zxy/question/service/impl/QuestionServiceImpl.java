package com.zxy.question.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxy.question.conversion.QuestionConversion;
import com.zxy.question.model.Option;
import com.zxy.question.model.Question;
import com.zxy.question.model.Survey;
import com.zxy.question.model.vo.QuestionVO;
import com.zxy.question.repository.OptionRepository;
import com.zxy.question.repository.QuestionRepository;
import com.zxy.question.repository.SurveyRepository;
import com.zxy.question.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private SurveyRepository surveyRepository;
    
    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private OptionRepository optionRepository;
    
    @Override
    public QuestionVO createOrUpdateQuestion(int id, QuestionVO questionVO) {
        Survey survey = surveyRepository.findById(id);
        Question question = QuestionConversion.questionVOToQuestion(questionVO, survey);
        if (questionVO.getId() != 0) {
            question.setId(questionVO.getId());
        }
        questionRepository.save(question);
        createOption(questionVO, question);
        return questionVO;
    }

    @Override
    @Transactional
    public Integer deleteQuestion(int question_id) {
        Question question = questionRepository.findById(question_id);
        optionRepository.deleteByQuestion(question);
        return questionRepository.deleteQuestion(question_id);
    }

    private void createOption(QuestionVO questionVO, Question question) {
        if (questionVO.getA() != null) {
            Option option = new Option();
            option.setCreateTime(new Date());
            option.setOptionName(questionVO.getA());
            option.setQuestion(question);
            option.setType("a");
            option.setChooseTimes(0);
            optionRepository.save(option);
        }
        if (questionVO.getB() != null) {
            Option option = new Option();
            option.setCreateTime(new Date());
            option.setOptionName(questionVO.getB());
            option.setQuestion(question);
            option.setType("b");
            option.setChooseTimes(0);
            optionRepository.save(option);
        }
        if (questionVO.getC() != null) {
            Option option = new Option();
            option.setCreateTime(new Date());
            option.setOptionName(questionVO.getC());
            option.setQuestion(question);
            option.setType("c");
            option.setChooseTimes(0);
            optionRepository.save(option);
        }
        if (questionVO.getD() != null) {
            Option option = new Option();
            option.setCreateTime(new Date());
            option.setOptionName(questionVO.getD());
            option.setQuestion(question);
            option.setType("d");
            option.setChooseTimes(0);
            optionRepository.save(option);
        }
        if (questionVO.getE() != null) {
            Option option = new Option();
            option.setCreateTime(new Date());
            option.setOptionName(questionVO.getE());
            option.setQuestion(question);
            option.setType("e");
            option.setChooseTimes(0);
            optionRepository.save(option);
        }
        if (questionVO.getF() != null) {
            Option option = new Option();
            option.setCreateTime(new Date());
            option.setOptionName(questionVO.getF());
            option.setQuestion(question);
            option.setType("f");
            option.setChooseTimes(0);
            optionRepository.save(option);
        }
        if (questionVO.getG() != null) {
            Option option = new Option();
            option.setCreateTime(new Date());
            option.setOptionName(questionVO.getG());
            option.setQuestion(question);
            option.setType("g");
            option.setChooseTimes(0);
            optionRepository.save(option);
        }
        if (questionVO.getH() != null) {
            Option option = new Option();
            option.setCreateTime(new Date());
            option.setOptionName(questionVO.getH());
            option.setQuestion(question);
            option.setType("h");
            option.setChooseTimes(0);
            optionRepository.save(option);
        }
    }

}
