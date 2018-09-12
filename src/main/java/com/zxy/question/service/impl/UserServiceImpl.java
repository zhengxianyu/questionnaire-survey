package com.zxy.question.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxy.question.conversion.UserConversion;
import com.zxy.question.model.User;
import com.zxy.question.model.vo.PasswordVO;
import com.zxy.question.model.vo.UserVO;
import com.zxy.question.repository.UserRepository;
import com.zxy.question.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserVO login(String nameEn, String password) {
        User user = userRepository.login(nameEn, password);
        UserVO userVO = UserConversion.userToUserVO(user);
        return userVO;
    }

    @Override
    public UserVO findById(int userId) {
        User user = userRepository.findById(userId);
        UserVO userVO = UserConversion.userToUserVO(user);
        return userVO;
    }

    @Override
    public UserVO updateUser(UserVO userVO) {
        User user = UserConversion.userVOToUser(userVO);
        userRepository.save(user);
        return userVO;
    }

    @Override
    @Transactional
    public PasswordVO updatePassword(PasswordVO passwordVO) {
        User user = userRepository.login(passwordVO.getNameEn(), passwordVO.getOldPassword());
        if (user != null) {
            userRepository.updatePassword(user.getId(), passwordVO.getNewPassword());
            return passwordVO;
        }
        return null;
    }

    @Override
    @Transactional
    public void saveImage(int id, String originalFilename) {
        userRepository.saveImage(id, originalFilename);
    }
}
