package com.team5101.controller;

import com.github.pagehelper.PageInfo;
import com.team5101.pojo.Notice;
import com.team5101.pojo.User;
import com.team5101.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//公告控制器
@Controller
public class  NoticeController {

    @Autowired
    private NoticeService noticeService;

    //显示通知信息
    @RequestMapping(value = "/Nlist.action")
    public String Nlist(@RequestParam(defaultValue = "1")  Integer pageNum, @RequestParam(defaultValue = "10") Integer rows,
                        String gg_title, String gg_fabuzhe, Date gg_date, Model model){

        PageInfo<Notice> notices = noticeService.findNoticeList(pageNum, rows, gg_title, gg_fabuzhe, gg_date);
        model.addAttribute("pageInfo", notices);
        model.addAttribute("gg_title", gg_title);
        model.addAttribute("gg_date", gg_date);
       // System.out.println(notices);
         return "notice";
    }

    //显示通知管理信息
    @RequestMapping(value = "/MNlist.action")
    public String MNlist(@RequestParam(defaultValue = "1")  Integer pageNum, @RequestParam(defaultValue = "10") Integer rows,
                        String gg_title, String gg_fabuzhe, Date gg_date, Model model){

        PageInfo<Notice> notices = noticeService.findNoticeList(pageNum, rows, gg_title, gg_fabuzhe, gg_date);
        //System.out.println(notices);
        model.addAttribute("pageInfo", notices);
        model.addAttribute("gg_title", gg_title);
        model.addAttribute("gg_date", gg_date);
        //model.addAttribute("gg_id", gg_id);
        // System.out.println(notices);
        return "noticeM";
    }

    /**
     * 添加通知
     *
     * @param notice
     * @param session
     * @return
     */
    @RequestMapping("/Ncreate.action")
    @ResponseBody
    public String noticeCreate(Notice notice, HttpSession session) {
         User user = (User) session.getAttribute("USER");
        int num=noticeService.getNoticeByTitle(notice.getGg_title());


        //  int num = studentService.getStudentBySno(student.getStud_sno());
        int check = 0;
        if (notice.getGg_title() == "" || notice.getGg_title() == null){
            check = 1;
        }
        else if (notice.getGg_content() == "" || notice.getGg_content() == null){
            check = 2;
        }
        if (num > 0) {
            return "EXIST";
        } else {
            if (check != 0) {
                String ck = String.valueOf(check);
                return "empty" + ck;
            }
            // 执行Service层中的创建方法，返回的是受影响的行数
            Date now=new Date();
            notice.setGg_date(now);
            notice.setGg_fabuzhe(user.getUsername());
            int rows = noticeService.createNotice(notice);//.createCustomer(customer);
            if (rows > 0) {
                return "OK";
            } else {
                return "FAIL";
            }
        }
    }

    /**
     * 根据Title获取通知内容
     */
    @RequestMapping("/NgetNoticeByT.action")
    @ResponseBody
    public Notice NgetNoticeByT(String gg_title) {
        //System.out.println(gg_title);
        Notice notice = noticeService.getNoticeByT(gg_title);
        Date now=new Date();
        notice.setGg_date(now);
        //System.out.println(notice);
        return notice;
    }

    /**
     * 显示详细内容
     */
    /*
    @RequestMapping("/NgetNoticeByTT.action")
    public String  getNoticeByTT(HttpServletRequest request, Model model) {
        String gg_title=request.getParameter("gg_title");


        Notice notice = noticeService.getNoticeByT(gg_title);

        model.addAttribute("gtitle", notice.getGg_title());
        model.addAttribute("gtext", notice.getGg_content());
        model.addAttribute("gtime", notice.getGg_date());
        //request.setAttribute("mainPage", "noticeDate.jsp");

            return "noticeM";

    }
     */


    /**
     * 更新通知信息
     *
     * @param notice
     * @return
     */

    @RequestMapping("/Nupdate.action")
    @ResponseBody
    public String Nupdate(Notice notice) {
        Date now =new Date();
        notice.setGg_date(now);
        // System.out.println(now);
        int rows = noticeService.updateNotice(notice);
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
     * @param gg_id
     * @return
     */
    @RequestMapping("/Ndelete.action")
    @ResponseBody
    public String noticeDelete(Integer gg_id) {

        int rows = noticeService.deleteNotice(gg_id);
        if (rows > 0) {
            return "OK";
        } else {
            return "FAIL";
        }
    }

    @RequestMapping("/Ndelete_all.action")
    @ResponseBody
    public void delectAll(HttpServletRequest request, HttpServletResponse response) {
        String items = request.getParameter("delitems");
        List<String> delList = new ArrayList<String>();
        System.out.println(delList);
        String[] strs = items.split(",");
        for (String str : strs) {
            delList.add(str);
        }
        noticeService.batchDeletes(delList);
        //userService.batchDeletes(delList);
    }



}
