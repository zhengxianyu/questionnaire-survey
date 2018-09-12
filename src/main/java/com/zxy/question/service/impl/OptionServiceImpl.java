package com.zxy.question.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxy.question.model.vo.SubmitVO;
import com.zxy.question.repository.OptionRepository;
import com.zxy.question.service.OptionService;

@Service
public class OptionServiceImpl implements OptionService {
    @Autowired
    private OptionRepository optionRepository;

    @Override
    @Transactional
    public void submitOptions(SubmitVO submitVO) {
        String radio[] = submitVO.getRadio();
        int radioLength = radio.length;
        for (int i = 0; i < radioLength; i++) {
            if ("select".equals(radio[i])) {
                optionRepository.selectTimes(i);
            }
        }
        
        String check[] = submitVO.getCheck();
        int checkLength = check.length;
        for (int i = 0; i < checkLength; i++) {
            if ("select".equals(check[i])) {
                optionRepository.selectTimes(i);
            }
        }
        
        String completion[] = submitVO.getCompletion();
        int completionLength = completion.length;
        for (int i = 0; i < completionLength; i++) {
            if (completion[i] != null) {
                optionRepository.setOptionValue(i, completion[i]);
            }
        }
    }

}
