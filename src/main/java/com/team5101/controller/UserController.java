package com.team5101.controller;


import com.team5101.pojo.User;
import com.team5101.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView login() {
        return new ModelAndView("login");
    }



    @RequestMapping(value="/login.action",method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView login(String username, String password, HttpSession session) {
        User user=userService.login(username,password);
        session.setAttribute("user",user);
        System.out.println(user);

            return new ModelAndView("login") ;

    }
    @RequestMapping("/error")
    public String error(){
        return "error";
    }




}
