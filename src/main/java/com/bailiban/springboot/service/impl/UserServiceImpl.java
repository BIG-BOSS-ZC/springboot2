package com.bailiban.springboot.service.impl;

import com.bailiban.springboot.mapper.UserMapper;
import com.bailiban.springboot.model.MyAdvice;
import com.bailiban.springboot.model.User;
import com.bailiban.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.getUser(user);
    }


    public User getUserById(int id){
        User user = userMapper.getUser(new User().setId(id));
        return user;
    }

    public int addUser(User user){
        return userMapper.addUser(user);
    }

    public List<MyAdvice> getAdvices(int uId){
        return userMapper.getAdvices(uId);
    }

    public int updateUser(User user){
        return userMapper.updateUser(user);
    }

    public int updateAdvice(MyAdvice myAdvice){
        return userMapper.updateAdvice(myAdvice);
    }

    public int addAdvice(MyAdvice myAdvice){
        return userMapper.addAdvice(myAdvice);
    }

    public int delAdvice(int id){
        return userMapper.delAdvice(id);
    }
}
