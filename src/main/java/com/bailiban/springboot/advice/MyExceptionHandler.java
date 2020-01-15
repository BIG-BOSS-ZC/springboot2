package com.bailiban.springboot.advice;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(BindException.class)
    public ModelAndView bindHandle(HttpServletRequest request,BindException ex){
        ModelAndView mv=new ModelAndView("register-error");
        StringBuilder sb=new StringBuilder();
        ex.getFieldErrors().forEach(
                e->{
                    sb.append(e.getField()+":"+e.getDefaultMessage()+"<br />");
                }
        );
        mv.addObject("errors",sb.toString());
        return mv;
    }
}
