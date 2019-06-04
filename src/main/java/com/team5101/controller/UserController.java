package com.team5101.controller;


import com.team5101.pojo.User;
import com.team5101.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public String login() {
        return "/login";
    }


    @RequestMapping(value="/login.action",method = {RequestMethod.POST, RequestMethod.GET})
    public String login(String username, String password){
        User user=userService.login(username,password);
        System.out.println(user);
        if(user!=null)
                return "/success";
        else
            return "/login";
    }
    @RequestMapping("/error")
    public String error(){
        return "error";
    }




}
