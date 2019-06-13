package com.team5101.controller;


import com.team5101.mapper.CompetitorMapper;
import com.team5101.pojo.Competitor;
import com.team5101.pojo.ContestInfo;
import com.team5101.pojo.SignUp;
import com.team5101.service.ContestInfoService;
import com.team5101.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;




//报名控制器
@RestController
public class RegController {
    @Autowired
    private SignUpService signUpService;
    @Autowired
    private ContestInfoService contestInfoService;
    @Autowired
    private CompetitorMapper competitorMapper;
    @RequestMapping("/baoming")
    public ModelAndView RegInfo(Model model){
        List<SignUp> signUps=signUpService.findAllSignUpInfo();
        model.addAttribute("signups",signUps);
        return new ModelAndView("baoming");
    }
    @RequestMapping("/baoming.getall")
    public ModelAndView getAllSignInfo(Model model){
        List<SignUp> signUps=signUpService.findAllSignUpInfo();
        model.addAttribute("signups",signUps);
        ModelAndView mv=new ModelAndView("baoming");
        return mv;
    }
    @RequestMapping("/contestInfo")
    public ModelAndView getAlltestInfo(Model model, Competitor competitor){
        List<ContestInfo> contestInfos=contestInfoService.findAllContestInfo();
        model.addAttribute("contestInfos",contestInfos);
        ModelAndView mv=new ModelAndView("ContestInfo");

        return mv;
    }
    @RequestMapping("/regcontestInfo")
    public String getReg(Model model, Competitor competitor, HttpServletRequest request){
        String sno = competitor.getC_sno();
        String name = competitor.getC_name();
        String sex = competitor.getC_gender();
        String major=competitor.getC_major();
        String phone =competitor.getC_phone();
        String qq=competitor.getC_qq();
        competitorMapper.addCompetitor(competitor);
        ModelAndView mv=new ModelAndView("ContestInfo");
        return "报名成功！";
    }
}
