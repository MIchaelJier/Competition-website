package com.team5101.xkjs.controller;


import com.team5101.xkjs.pojo.User;
import com.team5101.xkjs.service.UserService;
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



}
