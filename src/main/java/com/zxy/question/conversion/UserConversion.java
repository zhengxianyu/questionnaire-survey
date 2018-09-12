package com.zxy.question.conversion;

import com.zxy.question.model.User;
import com.zxy.question.model.vo.UserVO;

public class UserConversion {

    public static UserVO userToUserVO(User user) {
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setAddress(user.getAddress());
        userVO.setEmail(user.getEmail());
        userVO.setNameCh(user.getNameCh());
        userVO.setNameEn(user.getNameEn());
        userVO.setPhoneNumber(user.getPhoneNumber());
        userVO.setImage("http://localhost:8080/questionnairesurvey/image/"+user.getImage());
        return userVO;
    }

    public static User userVOToUser(UserVO userVO) {
        User user = new User();
        user.setId(userVO.getId());
        user.setAddress(userVO.getAddress());
        user.setEmail(userVO.getEmail());
        user.setPassword(userVO.getPassword());
        user.setNameCh(userVO.getNameCh());
        user.setNameEn(userVO.getNameEn());
        user.setPhoneNumber(userVO.getPhoneNumber());
        return user;
    }

}
