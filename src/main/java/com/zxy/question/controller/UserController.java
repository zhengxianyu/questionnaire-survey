package com.zxy.question.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zxy.question.model.vo.PasswordVO;
import com.zxy.question.model.vo.UserVO;
import com.zxy.question.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public UserVO Login(@RequestBody UserVO userVO) throws Exception {
        UserVO loginSuccess = userService.login(userVO.getNameEn(), userVO.getPassword());
        if (loginSuccess == null) {
            return null;
        }
        return loginSuccess;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserVO getUser(@PathVariable("id") int id) throws Exception {
        UserVO userVO = userService.findById(id);
        return userVO;
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public UserVO UpdateUser(@RequestBody UserVO userVO) throws Exception {
        UserVO newUserVO = userService.updateUser(userVO);
        return newUserVO;
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public PasswordVO UpdatePassword(@RequestBody PasswordVO passwordVO) throws Exception {
        PasswordVO newPasswordVO = userService.updatePassword(passwordVO);
        return newPasswordVO;
    }
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile image, @RequestParam("id") int id) throws Exception {
        String path = System.getProperty("user.dir");
        String savePath = path + "/src/main/resources/static/image";
        System.out.println(savePath);
        byte[] bs = new byte[1024];
        File saveFile=new File(savePath);
        InputStream isr = image.getInputStream();
        OutputStream os = new FileOutputStream(saveFile.getPath() + "/" + image.getOriginalFilename());
        int len;
        while ((len = isr.read(bs)) != -1) {  
            os.write(bs, 0, len);  
        }  
        // 完毕，关闭所有链接  
        os.close();  
        isr.close();
        userService.saveImage(id, image.getOriginalFilename());
        return "";
    }
}
