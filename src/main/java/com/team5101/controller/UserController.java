package com.team5101.controller;


import com.team5101.pojo.User;
import com.team5101.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    public ModelAndView login(@RequestParam("username")String username,@RequestParam("password")String password,
                              HttpServletRequest request, HttpSession session, Model model) {
        User user=userService.login(username,password);
        session.setAttribute("username",username);
        //request.getSession().setAttribute("username",username);
        System.out.println(user);

        return new ModelAndView("success") ;

    }
//    @RequestMapping("/error")
//    public String error(){
//        return "error";
//    }




}
