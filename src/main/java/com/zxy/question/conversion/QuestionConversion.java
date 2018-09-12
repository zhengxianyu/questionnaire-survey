package com.zxy.question.conversion;

import java.util.Date;
import java.util.List;

import com.zxy.question.model.Question;
import com.zxy.question.model.Survey;
import com.zxy.question.model.vo.OptionVO;
import com.zxy.question.model.vo.QuestionVO;

public class QuestionConversion {

    public static Question questionVOToQuestion(QuestionVO questionVO, Survey survey) {
        Question question = new Question();
        question.setCreateTime(new Date());
        question.setQuestionTitle(questionVO.getQuestionTitle());
        question.setSurvey(survey);
        question.setType(questionVO.getType());
        return question;
    }

    public static QuestionVO questionToQuestionVO(Question question, List<OptionVO> optionVOs, Integer allSelectTimes) {
        QuestionVO questionVO = new QuestionVO();
        questionVO.setId(question.getId());
        questionVO.setQuestionTitle(question.getQuestionTitle());
        questionVO.setOptionVOs(optionVOs);
        questionVO.setType(question.getType());
        questionVO.setAllSelectTimes(allSelectTimes);
        return questionVO;
    }

}
