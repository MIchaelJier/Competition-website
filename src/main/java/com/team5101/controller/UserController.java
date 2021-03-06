package com.team5101.controller;


import com.team5101.mapper.UserMapper;
import com.team5101.pojo.Competitor;
import com.team5101.pojo.User;
import com.team5101.service.NoticeService;
import com.team5101.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.record.FilePassRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.UUID;


@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

   //初始页
    @RequestMapping(value = "/", method = { RequestMethod.GET})
    public String  login() {
        return "login";
    }

    //检验
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(String username,String password) {
            Integer num=userService.CheckUser(username, password);
           /* System.out.println(num);*/


            if(num==0)
                return "error";
            else
                return "ok";
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
            User u= (User) request.getSession().getAttribute("USER");
            Competitor competitor =userService.findInfo(u.getU_sno());
            session.setAttribute("userInfo",competitor);
            System.out.println(competitor);
            return "index2" ;
        }
        return "login";
    }
    //个人信息
    @RequestMapping(value = "/userInfo", method = {RequestMethod.POST, RequestMethod.GET})
    public String  userInfo(HttpServletRequest request, HttpSession session, Model model) {

        User u= (User) request.getSession().getAttribute("USER");
        Competitor competitor =userService.findInfo(u.getU_sno());
        model.addAttribute("userInfo",competitor);
        return "userInfo";
    }
    //个人信息修改
    @RequestMapping(value = "/updateInfo")
    public String updateOne(Competitor competitor){
        try{
            System.out.println(competitor.toString());
            userMapper.updateOne(competitor);
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        return "redirect:/userInfo";

    }

    //注销
    @RequestMapping(value="/logout.action")
    public String logout(HttpServletRequest request, HttpSession session, Model model){
       // String username=  session.getAttribute("USER.username").toString();
        //System.out.println("1:"+username);
        //session.invalidate();
        //session.removeAttribute("USER");
        //username=  session.getAttribute("USER.username").toString();
        //System.out.println("2:"+username);
        Enumeration em = request.getSession().getAttributeNames();
        while(em.hasMoreElements()){
            request.getSession().removeAttribute(em.nextElement().toString());
            //System.out.println(session.toString());
            //System.out.println("清除Seesion");
//            session.invalidate();
        }
            return "redirect:/";
    }
    //主页
    @RequestMapping(value="/index")
    public String index(HttpServletRequest request, HttpSession session, Model model){
        return "index2";
    }
    //竞赛成绩
    @RequestMapping(value="/ContestResult")
    public String ContestResult(HttpServletRequest request, HttpSession session, Model model){
        return "ContestResult";
    }
    @ResponseBody
    @RequestMapping(value="/updatePassword")
    public String updatePassword(HttpServletRequest request, @RequestParam("password")String password,@RequestParam("oldpassword")String oldpassword){
        User u= (User) request.getSession().getAttribute("USER");
        Integer num=userService.CheckUser(u.getUsername(), oldpassword);
        /* System.out.println(num);*/
        if(num==0){
            System.out.println("原密码错误");
            return "原密码不正确";
        }
        else{
            userMapper.updatePassword(u.getUsername(),password);
            System.out.println("修改成功");
            return "修改成功";
        }

    }





}
