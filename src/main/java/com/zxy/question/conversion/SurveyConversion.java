package com.zxy.question.conversion;

import java.util.Date;
import java.util.List;

import com.zxy.question.model.Survey;
import com.zxy.question.model.User;
import com.zxy.question.model.vo.QuestionVO;
import com.zxy.question.model.vo.SurveyVO;
import com.zxy.question.util.DateUtil;

public class SurveyConversion {

    public static SurveyVO surveyToSurveyVO(Survey survey, List<QuestionVO> qustionVOs) {
        SurveyVO surveyVO = new SurveyVO();
        surveyVO.setKey(survey.getId());
        surveyVO.setSurveyTitle(survey.getSurveyTitle());
        surveyVO.setSurveyDetail(survey.getSurveyDetail());
        surveyVO.setQustionVOs(qustionVOs);
        surveyVO.setSponsor(survey.getUser().getNameEn());
        surveyVO.setStatus(survey.getStatus());
        getStatusCh(surveyVO);
        surveyVO.setTime(DateUtil.dateToString(survey.getCreateTime()));
        
        if (survey.getExpiredTime() != null) {
            Date createTime = survey.getCreateTime();
            surveyVO.setCreateTime(DateUtil.dateToString(createTime));
            Date expiredTime = survey.getExpiredTime();
            surveyVO.setExpiredTime(DateUtil.dateToString(expiredTime));
        }
        
        return surveyVO;
    }

    public static Survey surveyVOToSurvey(SurveyVO surveyVO,
            User user, Survey survey) {
        survey.setCreateTime(new Date());
        survey.setSurveyTitle(surveyVO.getSurveyTitle());
        survey.setSurveyDetail(surveyVO.getSurveyDetail());
        survey.setUser(user);
        survey.setStatus("creating");
        return survey;
    }
    
    private static void getStatusCh(SurveyVO surveyVO) {
        if (surveyVO.getStatus().equals("creating")) {
            surveyVO.setStatusCh("创建中");
        } else if (surveyVO.getStatus().equals("save")) {
            surveyVO.setStatusCh("草稿");
        } else if (surveyVO.getStatus().equals("publish")) {
            surveyVO.setStatusCh("已发布");
        } else if (surveyVO.getStatus().equals("stop")) {
            surveyVO.setStatusCh("停用");
        }
    }

}
