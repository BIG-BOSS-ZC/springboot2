package com.bailiban.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.regex.Matcher;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class User {
    private Integer id;
    @NotEmpty(message = "用户名不能为空！")
    private String name;
    @Size(min = 6,max = 18,message = "密码长度应该在6-18之间！")
    private String password;
    private String sex;
    @Pattern(regexp = "^1[34578]\\d{9}$",message = "手机号码格式不正确！")
    private String phoneNumber;
    @Email(message = "邮箱格式不正确！")
    private String email;
    private String hobbit;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
