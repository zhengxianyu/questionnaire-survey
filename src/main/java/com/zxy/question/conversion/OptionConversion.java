package com.zxy.question.conversion;

import com.zxy.question.model.Option;
import com.zxy.question.model.vo.OptionVO;

public class OptionConversion {

    public static OptionVO optionToOptionVO(Option option) {
        OptionVO optionVO = new OptionVO();
        optionVO.setId(option.getId());
        optionVO.setOptionName(option.getOptionName());
        optionVO.setSelectTimes(option.getChooseTimes());
        return optionVO;
    }

}
