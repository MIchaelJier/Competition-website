package com.team5101.controller;

import com.github.pagehelper.PageInfo;
import com.team5101.pojo.Notice;
import com.team5101.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

//公告控制器
@Controller
public class  NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/Nlist.action")
    public String Nlist(@RequestParam(defaultValue = "1")  Integer pageNum, @RequestParam(defaultValue = "10") Integer rows,
                        String gg_title, String gg_fabuzhe, Date gg_date, Model model){

        PageInfo<Notice> notices = noticeService.findNoticeList(pageNum, rows, gg_title, gg_fabuzhe, gg_date);
        model.addAttribute("pageInfo", notices);
        System.out.println(notices);
      // return "index2";
         return "notice";
    }


}
