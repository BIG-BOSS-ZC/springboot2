package com.bailiban.springboot.controller;

import com.bailiban.springboot.model.MyAdvice;
import com.bailiban.springboot.model.User;
import com.bailiban.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public String login(User user, HttpSession session){
        System.out.println("[login form]\t"+user.toString());
        User login = userService.login(user);
        if(login!=null){
            session.setAttribute("user",login);
            System.out.println("[login user]\t"+login.toString());
            return "redirect:/user/home";
        }
        return "login";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("home")
    public String home(HttpSession session,ModelMap modelMap){
        if(session.getAttribute("user")==null){
            //没有登录
            return "redirect:/user/login";
        }
        modelMap.addAttribute(session.getAttribute("user"));
        return "home";
    }





    @GetMapping("update")
    public String update(@SessionAttribute User user){
        return "update";
    }

    @PostMapping("update")
    public String update(User user,HttpSession session){
        System.out.println("[update]\t"+user.toString());
        int i = userService.updateUser(user);
        if(i!=0){
            session.setAttribute("user",user);
            return "redirect:/user/home";
        }
        return "errors/error";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/user/login";
    }

    @GetMapping("register")
    public String register(){
        return "register";
    }

    @PostMapping("register")
    public String register(@Validated User user, RedirectAttributes redirectAttributes){
        userService.addUser(user);
        return "redirect:/user/login";
    }

    @RequestMapping("table")
    @ResponseBody
    public Map<String,Object> table(@SessionAttribute User user,int page,int limit){
        Map<String,Object> map=new HashMap<>();
        List<MyAdvice> advices = userService.getAdvices(user.getId());
        map.put("code",0);
        map.put("count",advices.size());
        map.put("data",advices.subList((page-1)*limit,Math.min(advices.size(),page*limit)));
        return map;
    }

    @RequestMapping("table/edit")
    @ResponseBody
    public String edit(MyAdvice e){

        userService.updateAdvice(e);
        return "success";
    }

    @RequestMapping("table/del")
    @ResponseBody
    public String del(int id){
        userService.delAdvice(id);
        return "success";
    }

    @RequestMapping("table/add")
    @ResponseBody
    public String add(MyAdvice myAdvice,HttpSession session){
        User user=(User)session.getAttribute("user");
        myAdvice.setUId(user.getId());
        userService.addAdvice(myAdvice);
        return "success";
    }
}
