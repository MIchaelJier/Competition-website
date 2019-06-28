package com.team5101.service;

import com.team5101.pojo.SignUp;

import java.util.List;

public interface SignUpService {


    //获取所有竞赛报名信息
    List<SignUp> findAllSignUpInfo(Integer j_id);
}
