package com.zxy.question;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.zxy.question.model.User;
import com.zxy.question.model.vo.UserVO;
import com.zxy.question.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=QuestionnaireSurveyApplication.class)
@WebAppConfiguration
public class UserServiceTest {
    @Autowired
    private UserService userService;
    
    @Test
    public void Login() {
        User user = new User();
        user.setId(1);
        user.setNameEn("kody");
        user.setPassword("1006");
        UserVO loginSuccess = userService.login(user.getNameEn(), user.getPassword());
        if (loginSuccess == null) {
            System.out.println("failed!");
        }
        System.out.println("success:" + loginSuccess);
    }
    
    @Test
    public void getUser() {
        int id = 1;
        UserVO userVO = userService.findById(id);
        System.out.println(userVO);
    }
    
    @Test
    public void UpdateUser() {
        UserVO user = new UserVO();
        user.setId(1);
        user.setPhoneNumber("13343812948");
        UserVO newUser = userService.updateUser(user);
        System.out.println(newUser);
        System.out.println("update success");
    }
}
