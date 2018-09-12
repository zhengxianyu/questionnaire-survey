package com.zxy.question.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.zxy.question.model.Option;
import com.zxy.question.model.Question;

public interface OptionRepository extends CrudRepository<Option, String> {

    @Query("select option from Option option where option.question=?1 and option.expiredTime=null")
    List<Option> finaAllOptions(Question question);

    @Modifying
    @Query("update Option option set option.expiredTime=now() where option.question=?1")
    void deleteByQuestion(Question question);

    @Modifying
    @Query("update Option option set option.chooseTimes=option.chooseTimes+1 where option.id=?1")
    void selectTimes(int i);

    @Modifying
    @Query("update Option option set option.optionName=?2 where option.id=?1")
    void setOptionValue(int i, String string);

}

