package com.zxy.question.service;

import com.zxy.question.model.vo.PasswordVO;
import com.zxy.question.model.vo.UserVO;

public interface UserService {

    UserVO login(String nameEn, String password);

    UserVO findById(int userId);

    UserVO updateUser(UserVO userVO);

    PasswordVO updatePassword(PasswordVO passwordVO);

    void saveImage(int id, String originalFilename);
    
}
