package com.zxy.question.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.zxy.question.model.User;

public interface UserRepository extends CrudRepository<User, String> {

    @Query("select user from User user where user.nameEn=?1 and user.password=?2")
    User login(String nameEn, String password);

    @Query("select user from User user where user.id=?1 and user.expiredTime=null")
    User findById(int userId);

    @Modifying
    @Query("update User user set user.password=?2 where user.id=?1")
    void updatePassword(int id, String newPassword);

    @Modifying
    @Query("update User user set user.image=?2 where user.id=?1")
    void saveImage(int id, String originalFilename);

}
