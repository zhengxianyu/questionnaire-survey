package com.zxy.question.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxy.question.conversion.OptionConversion;
import com.zxy.question.conversion.QuestionConversion;
import com.zxy.question.conversion.SurveyConversion;
import com.zxy.question.model.Option;
import com.zxy.question.model.Question;
import com.zxy.question.model.Survey;
import com.zxy.question.model.User;
import com.zxy.question.model.vo.OptionVO;
import com.zxy.question.model.vo.QuestionVO;
import com.zxy.question.model.vo.StatusVO;
import com.zxy.question.model.vo.SurveyVO;
import com.zxy.question.model.vo.TypeVO;
import com.zxy.question.repository.OptionRepository;
import com.zxy.question.repository.QuestionRepository;
import com.zxy.question.repository.SurveyRepository;
import com.zxy.question.repository.UserRepository;
import com.zxy.question.service.SurveyService;

@Service
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private OptionRepository optionRepository;
    
    @Override
    public void createOrUpdateSurvey(SurveyVO surveyVO) {
        Survey survey = new Survey();
        if (surveyVO.getKey() != 0) {
            survey.setId(surveyVO.getKey());
        }
        if (surveyVO != null) {
            User user = userRepository.findById(surveyVO.getUserId());
            Survey newSurvey = SurveyConversion.surveyVOToSurvey(surveyVO, user, survey);
            surveyRepository.save(newSurvey);
        }
    }

    @Override
    public List<SurveyVO> getAllSurveys(int userId, String type, String search_value) {
        User user = userRepository.findById(userId);
        List<Survey> surveys = new ArrayList<>();
        if (user == null) {
            return null;
        }
        if (type != null) {
            if (search_value != null) {
                surveys = surveyRepository.findSearchSurveys(user, type, search_value);
            } else {
                surveys = surveyRepository.findSurveysByType(user, type);
            }
        } else {
            if (search_value != null) {
                surveys = surveyRepository.findSearchSurveys(user, search_value);
            } else {
                surveys = surveyRepository.findAllSurveys(user);
            }
        }
        
        List<SurveyVO> surveyVOs = new ArrayList<>();
        for (Survey survey: surveys) {
            if (survey != null) {
                SurveyVO surveyVO = SurveyConversion.surveyToSurveyVO(survey, null);
                surveyVOs.add(surveyVO);
            }
        }
        
        return surveyVOs;
    }

    @Override
    @Transactional
    public Integer deleteSurvey(int id) {
        return surveyRepository.deleteSurvey(id);
    }

    @Override
    public SurveyVO getSurvey(int surveyId) {
        Survey survey = surveyRepository.findById(surveyId);
        List<Question> questions = questionRepository.findAllQuestions(survey);
        List<QuestionVO> qustionVOs = new ArrayList<>();
        TypeVO typeVO = new TypeVO();
        typeVO.setRadio(questionRepository.findByType(survey, "radio"));
        typeVO.setCheck(questionRepository.findByType(survey, "check"));
        typeVO.setCompletion(questionRepository.findByType(survey, "completion"));
        
        for (Question question:questions) {
            QuestionVO questionVO = new QuestionVO();
            List<Option> options = optionRepository.finaAllOptions(question);
            List<OptionVO> optionVOs = new ArrayList<>();
            //计算一个问题中所以选项被选中次数总和
            Integer allSelectTimes = 0;
            for (Option option : options) {
                OptionVO optionVO = new OptionVO();
                allSelectTimes += option.getChooseTimes();
                optionVO = OptionConversion.optionToOptionVO(option);
                optionVOs.add(optionVO);
            }
            questionVO = QuestionConversion.questionToQuestionVO(question, optionVOs, allSelectTimes);
            qustionVOs.add(questionVO);
        }
        SurveyVO surveyVO = SurveyConversion.surveyToSurveyVO(survey, qustionVOs);
        surveyVO.setTypeVO(typeVO);
        return surveyVO;
    }

    @Override
    @Transactional
    public Integer changeStatus(int surveyId, String surveyStatus) {
        return surveyRepository.changeStatus(surveyId, surveyStatus);
    }

    @Override
    public StatusVO findAllStatus(int id) {
        User user = userRepository.findById(id);
        StatusVO statusVO = new StatusVO();
        int creating = surveyRepository.countCreating(user, "creating");
        int save = surveyRepository.countCreating(user, "save");
        int publish = surveyRepository.countCreating(user, "publish");
        int stop = surveyRepository.countCreating(user, "stop");
        statusVO.setCreating(creating);
        statusVO.setSave(save);
        statusVO.setPublish(publish);
        statusVO.setStop(stop);
        return statusVO;
    }

}
