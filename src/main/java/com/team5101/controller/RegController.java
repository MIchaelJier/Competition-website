package com.team5101.controller;


import com.team5101.mapper.CompetitorMapper;
import com.team5101.mapper.GroupMapper;
import com.team5101.mapper.SignUpMapper;
import com.team5101.mapper.UserMapper;
import com.team5101.pojo.*;
import com.team5101.service.ContestInfoService;
import com.team5101.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;




//报名控制器
@RestController
public class RegController {

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


    public static String generateRandomStr(int len) {
        //字符源，可以根据需要删减
        String generateSource = "23456789abcdefghgklmnpqrstuvwxyz";//去掉1和i ，0和o
        String rtnStr = "";
        for (int i = 0; i < len; i++) {
            //循环随机获得当次字符，并移走选出的字符
            String nowStr = String.valueOf(generateSource.charAt((int) Math.floor(Math.random() * generateSource.length())));
            rtnStr += nowStr;
            generateSource = generateSource.replaceAll(nowStr, "");
        }
        return rtnStr;
    }

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
    public String creatGroup(@RequestParam("g_name")String g_name,Group group,HttpServletRequest request){
        try {
            if(g_name==null||g_name.equals("")){
                return "请输入小组名";
            }
            User u = (User) request.getSession().getAttribute("USER");
            if(groupMapper.findGname(g_name)==null){
                String value="";
                value= generateRandomStr(8);
                group.setG_name(g_name);
                group.setG_sn1(u.getU_sno());
                group.setG_code(value);
                System.out.println(group.toString());
                groupMapper.addGroup(group);
                System.out.println(value);
                return "创建成功，你的邀请码是"+value;
            }else{
                return "小组名已存在";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "小组名已存在";
    }
    //我的小组
    @RequestMapping("/GroupInfo")
    public List<Group> allMember(@Param("g_name")String g_name, Model model, HttpServletRequest request){
        User u = (User) request.getSession().getAttribute("USER");
        List<Group> groups =groupMapper.findAllMember(u.getU_sno());
        return groups;
    }
    //所有小组信息
    @RequestMapping("/Group.getAll")
    public List<Group> allGroup(Model model){
        List<Group> groupList=groupMapper.allGroups();
        return groupList;
    }
    //加入小组
    @RequestMapping("/joinGroup")
    public String joinGroup(@RequestParam("g_code")String g_code,HttpServletRequest request,User u){

        String sno=request.getParameter("s_no");
        Group group=new Group();
        group.setG_code(g_code);
        group=groupMapper.findGroupByCode(group);
        System.out.println("原小组："+group);
        if(group.getG_sn2() == null||group.getG_sn2().equals("")){
            group.setG_sn2(sno);
            System.out.println(sno);
            groupMapper.joinGroup(group);

            return "加入成功";
        }
        if(group.getG_sn3()==null||group.getG_sn3().equals("")){
            group.setG_sn3(sno);
            System.out.println(group);
            groupMapper.joinGroup(group);

            return "加入成功";
        }
        if(group.getG_sn4()==null||group.getG_sn4().equals("")){
            group.setG_sn4(sno);
            System.out.println(group);
            groupMapper.joinGroup(group);

            return "加入成功";
        }
        return "加入失败,或人数已满";
    }
}
