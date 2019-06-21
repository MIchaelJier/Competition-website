package com.team5101.controller;


import com.team5101.pojo.User;
import com.team5101.service.NoticeService;
import com.team5101.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private NoticeService noticeService;

//    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
//    public ModelAndView login() {
//        return new ModelAndView("login");
//    }
//
//
//
//    @RequestMapping(value="/login.action",method = {RequestMethod.POST, RequestMethod.GET})
//    public ModelAndView login(@RequestParam("username")String username,@RequestParam("password")String password,
//                              HttpServletRequest request, HttpSession session, Model model) {
//        User user=userService.login(username,password);
//        session.setAttribute("username",username);
//
//        //request.getSession().setAttribute("username",username);
//        System.out.println(user);
//
//        return new ModelAndView("success") ;
//
//    }
//
//
//
//
   //初始页
    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public String  login() {
        return "login";
    }


    //跳转到主页
    @RequestMapping(value="/login.action",method = {RequestMethod.POST, RequestMethod.GET})
    public String login( @RequestParam("username")String username, @RequestParam("password")String password,
                        HttpServletRequest request, HttpSession session, Model model) {
        User user=userService.login(username,password);
        //session.setAttribute("username",username);

        //request.getSession().setAttribute("username",username);
        if(user!=null){
            System.out.println(user);
            session.setAttribute("USER",user);

            return "index2" ;
        }
      // else
       // return
         return "ERROR";


    }

    //注销
    @RequestMapping(value="/logout.action")
    public String logout(HttpServletRequest request, HttpSession session, Model model){
       // String username=  session.getAttribute("USER.username").toString();
        //System.out.println("1:"+username);
        session.removeAttribute("USER");
        //username=  session.getAttribute("USER.username").toString();
        //System.out.println("2:"+username);
            return "redirect:/";
    }
    @RequestMapping(value="/index")
    public String index(HttpServletRequest request, HttpSession session, Model model){
        return "index2";
    }

}
