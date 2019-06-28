package com.team5101.controller;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.team5101.mapper.CompetitorMapper;
import com.team5101.mapper.GroupMapper;
import com.team5101.mapper.SignUpMapper;
import com.team5101.mapper.UserMapper;
import com.team5101.pojo.*;
import com.team5101.service.ContestInfoService;
import com.team5101.service.SignUpService;
import com.team5101.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SignUpMapper signUpMapper;
    @Autowired
    private GroupMapper groupMapper;

    //查询报名信息界面

    @RequestMapping("/baoming")
    public ModelAndView RegInfo(){
        return new ModelAndView("baoming");
    }

    //查询单个竞赛所有报名信息
    @RequestMapping("/baomingAllInfo")
    public List<SignUp> getAllSignInfo(HttpServletRequest request){
        String j_id=request.getParameter("j_id");
        System.out.println(j_id);
        List<SignUp> signUps=signUpMapper.getAllContestByJno(Integer.valueOf(j_id));
        System.out.println(signUps);
        return signUps;
    }


    //报名界面
    @RequestMapping("/contestInfo")
    public ModelAndView getAlltestInfo(Model model, Competitor competitor,HttpServletRequest request){
        List<ContestInfo> contestInfos=contestInfoService.findAllContestInfo();
        model.addAttribute("contestInfos",contestInfos);
        ModelAndView mv=new ModelAndView("ContestInfo");
        User u= (User) request.getSession().getAttribute("USER");
        List<SignUp> signUps=signUpMapper.findSigUPInfo(u.getU_id());
        Competitor c =userService.findInfo(u.getU_sno());
        model.addAttribute("userInfo",c);
        System.out.println(signUps);

        return mv;
    }





    //返回已报名竞赛ID列表
    @RequestMapping("/findSigUPInfo")
    public List<SignUp> findSigUPInfo(Model model, HttpServletRequest request){

        User u= (User) request.getSession().getAttribute("USER");
        List<SignUp> signUps=signUpMapper.findSigUPInfo(u.getU_id());
        Competitor c =userService.findInfo(u.getU_sno());

        System.out.println(signUps);

        return signUps;
    }

    //提交报名信息
    @RequestMapping("/regcontestInfo")
    public String getReg(Model model, Competitor competitor, HttpServletRequest request,SignUp signUp) {
        User u = (User) request.getSession().getAttribute("USER");
        Integer c_id = u.getU_id();
        String contestid = request.getParameter("j_id");
        signUp.setC_id(c_id);

        signUp.setJ_id(Integer.parseInt(contestid));
        if (signUpMapper.findInfo(signUp)>=1) {

            return "已报名，请勿重复报名";
        } else {
            System.out.println(contestid);
            signUpMapper.addOne(signUp);
            userMapper.updateOne(competitor);
            ModelAndView mv = new ModelAndView("ContestInfo");
            return "报名成功！";
        }
    }
    //创建小组信息填写
    @RequestMapping("/CreatGroupInfo")
    public ModelAndView CreatGroupInfo(Model model, HttpServletRequest request){
        User u = (User) request.getSession().getAttribute("USER");
        Competitor competitor =userService.findInfo(u.getU_sno());
        model.addAttribute("userInfo",competitor);

        return new ModelAndView("CreatGroupInfo");
    }
    //创建小组
    @RequestMapping("/CreatGroup")
    public String creatGroup(Group group){
        try {
            if(group.getG_name()==null||group.getG_name().equals("")){
                return "请输入小组名";
            }
            if(groupMapper.findMember(group.getG_name())!=null){
                return "小组名已存在";
            }
            if (group.getG_sn2() != null && !group.getG_sn2().equals("")) {
                if(groupMapper.GroupInfoBySno(group.getG_sn1())!=null){
                    return "学号1已存在小组";
                }
                if (groupMapper.GroupInfoBySno(group.getG_sn2()) != null) {
                    return "学号2已存在小组";
                }
                groupMapper.addGroup(group);
                System.out.println(group.toString());
                return "创建成功！";
            }
            else if(group.getG_sn3()!=null&&group.getG_sn3().equals("")){
                if (groupMapper.GroupInfoBySno(group.getG_sn1()) != null &&
                        groupMapper.GroupInfoBySno(group.getG_sn3()) != null &&
                        groupMapper.findMember(group.getG_name()) != null) {
                    groupMapper.addGroup(group);
                    System.out.println(group.toString());
                    return "创建成功！";
                }else {
                    return "学号3已存在小组";
                }
            }
            else if(group.getG_sn4()!=null&&group.getG_sn4().equals("")){
                if (groupMapper.GroupInfoBySno(group.getG_sn1()) != null &&
                        groupMapper.GroupInfoBySno(group.getG_sn4()) != null &&
                        groupMapper.findMember(group.getG_name()) != null) {
                    groupMapper.addGroup(group);
                    System.out.println(group.toString());
                    return "创建成功！";
                }else {
                    return "学号4已存在小组";
                }
            }

            else{
                groupMapper.addGroup(group);
                System.out.println(group.toString());
                return "创建成功！";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "数据异常";
    }
    //成员信息
    @RequestMapping("/GroupInfo")
    public ModelAndView allMember(@Param("g_name")String g_name, Model model, HttpServletRequest request){
        User u = (User) request.getSession().getAttribute("USER");
        Group group=groupMapper.findMember(g_name);
        model.addAttribute("groups",group);
        return new ModelAndView("GroupInfo");
    }
    //所有小组信息
    @RequestMapping("/Group.getAll")
    public ModelAndView allGroup(Model model){
        model.addAttribute("groups",groupMapper.allGroups());
        return new ModelAndView("GroupInfo");
    }
}
