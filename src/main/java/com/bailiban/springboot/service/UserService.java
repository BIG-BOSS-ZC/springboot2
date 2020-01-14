package com.bailiban.springboot.service;

import com.bailiban.springboot.model.MyAdvice;
import com.bailiban.springboot.model.User;

import java.util.List;

public interface UserService {
    User login(User user);
    User getUserById(int id);
    int addUser(User user);
    List<MyAdvice> getAdvices(int uId);
    int updateUser(User user);
    int updateAdvice(MyAdvice myAdvice);
    int addAdvice(MyAdvice myAdvice);
    int delAdvice(int id);
}
