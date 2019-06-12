package com.team5101.controller;


import com.team5101.pojo.SignUp;
import com.team5101.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;




//报名控制器
@RestController
public class RegController {
    @Autowired
    private SignUpService signUpService;
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
}
