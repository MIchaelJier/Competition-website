package com.team5101.controller;


import com.github.pagehelper.PageInfo;
import com.team5101.pojo.ContestInfo;
import com.team5101.pojo.User;
import com.team5101.service.ContestInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.System.console;
import static java.lang.System.out;

//竞赛管理控制器
@Controller
public class ContestController {


    @Autowired
    private ContestInfoService contestInfoService;

    //显示通知管理信息
    @RequestMapping(value = "/mclist.action")
    public String mclist(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer rows,
                         String j_name, String j_type, String j_introduction, String j_href, Date j_starttime, Date j_endtime, Model model) {
        PageInfo<ContestInfo> contestInfos = contestInfoService.findContestList(pageNum, rows, j_name, j_type, j_introduction, j_href, j_starttime, j_endtime);
        model.addAttribute("pageInfo", contestInfos);
        model.addAttribute("j_name", j_name);
        model.addAttribute("j_type", j_type);
        model.addAttribute("j_introduction", j_introduction);
        model.addAttribute("j_href", j_href);
        model.addAttribute("j_starttime", j_starttime);
        model.addAttribute("j_endtime", j_endtime);
        return "ContestinfoM";
    }


    /**
     * 添加竞赛
     *
     * @param //contestInfo
     * @param session
     * @return
     */
    @RequestMapping("/Ccreate.action")
    @ResponseBody
    public String contestCreate(String j_name,String j_type,String j_href,String j_starttime, String j_endtime ,String j_introduction,HttpSession session) throws ParseException {
         User user = (User) session.getAttribute("USER");
        ContestInfo contestInfo=new ContestInfo();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if (j_starttime != "" || j_starttime != null){
            Date begin = sdf.parse(j_starttime);
            contestInfo.setJ_starttime(begin);
        }
       if (j_endtime != "" || j_endtime != null){
           Date endt  = sdf.parse(j_endtime);
           contestInfo.setJ_endtime(endt);
        }
        contestInfo.setJ_name(j_name);
        contestInfo.setJ_type(j_type);
        contestInfo.setJ_href(j_href);
        contestInfo.setJ_int(j_introduction);
       // System.out.println(contestInfo);
        int num=contestInfoService.getContestByName(contestInfo.getJ_name());
       //System.out.println(num);
       int check = 0;

        if (contestInfo.getJ_name() == "" || contestInfo.getJ_name() == null){
            check = 1;//比赛名称：
        }
        else if ( contestInfo.getJ_type()== "" || contestInfo.getJ_type() == null){
            check = 2;//比赛类型：
        }
        else if ( contestInfo.getJ_href()== "" || contestInfo.getJ_href() == null){
            check = 3;//官方网址：
        }

        else if (j_introduction == "" || j_introduction == null){
            check =4;//详情介绍：
        }


        if (num > 0) {
            return "EXIST";
        } else {
            if (check != 0) {
                String ck = String.valueOf(check);
                return "empty" + ck;
            }
            // 执行Service层中的创建方法，返回的是受影响的行数

            int rows = contestInfoService.createContest(contestInfo);
            if (rows > 0) {
                return "OK";
            } else {
                return "FAIL";
            }
        }
    }





    /**
     * 根据id获取通知内容
     */

    @RequestMapping("/CgetContestById.action")
    @ResponseBody
    public  ContestInfo CgetContestById(Integer  j_id) {

        ContestInfo contestInfo=contestInfoService.getContestById(j_id);
        //System.out.println(contestInfo);
        return contestInfo;
    }



    /**
     * 更新通知信息
     *
     * @param
     * @return
     */

    @RequestMapping("/Cupdate.action")
    @ResponseBody
    public String Cupdate(Integer j_id,String j_name,String j_type,String j_href,String j_starttime, String j_endtime ,String j_introduction,HttpSession session) throws ParseException {

        ContestInfo contestInfo=new ContestInfo();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if ( j_starttime != null||j_starttime !=""){
            Date begin = sdf.parse(j_starttime);
            contestInfo.setJ_starttime(begin);
        }
        if ( j_endtime != null||j_starttime !=""){
            Date endt  = sdf.parse(j_endtime);
            contestInfo.setJ_endtime(endt);
        }
      //  int t=Integer.parseInt(j_id);
        contestInfo.setJ_id(j_id);
        contestInfo.setJ_name(j_name);
        contestInfo.setJ_type(j_type);
        contestInfo.setJ_href(j_href);
        contestInfo.setJ_int(j_introduction);
        System.out.println("====="+contestInfo+"=====");
        int rows = contestInfoService.updateContest(contestInfo);
        System.out.println(rows);
        if (rows > 0) {
            return "OK";
        } else {
            return "FAIL";
        }

    }


    /**
     * 删除通知信息
     *
     * @param
     * @return
     */

    @RequestMapping("/Cdelete.action")
    @ResponseBody
    public String contestDelete(Integer j_id) {

        int rows = contestInfoService.deleteContest(j_id);
        if (rows > 0) {
            return "OK";
        } else {
            return "FAIL";
        }
    }
/*
    @RequestMapping("/Ndelete_all.action")
    @ResponseBody
    public void delectAll(HttpServletRequest request, HttpServletResponse response) {
        String items = request.getParameter("delitems");
        List<String> delList = new ArrayList<String>();
        String[] strs = items.split(",");
        for (String str : strs) {
            delList.add(str);
        }
        noticeService.batchDeletes(delList);
        //userService.batchDeletes(delList);
    }


     */
    @RequestMapping(value = "/CL.action")
    public String cl() {
        return "competition";
    }
}
