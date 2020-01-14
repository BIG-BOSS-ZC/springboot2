package com.bailiban.springboot.mapper;

import com.bailiban.springboot.model.MyAdvice;
import com.bailiban.springboot.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    User getUser(User user);

    int updateUser(User user);


    @Insert("insert into userinfo(name,password,sex,phone_number,email,hobbit,birthday) values(#{name},#{password},#{sex},#{phoneNumber},#{email},#{hobbit},#{birthday})")
    int addUser(User user);


    @Select("select * from advice where u_id=#{uId}")
    List<MyAdvice> getAdvices(int uId);

    @Update("update advice set name=#{name},money=#{money},miaoshu=#{miaoshu} where id=#{id}")
    int updateAdvice(MyAdvice myAdvice);

    @Insert("insert into advice(name,money,miaoshu,u_id) values(#{name},#{money},#{miaoshu},#{uId})")
    int addAdvice(MyAdvice myAdvice);

    @Delete("delete from advice where id=#{id}")
    int delAdvice(int id);
}
