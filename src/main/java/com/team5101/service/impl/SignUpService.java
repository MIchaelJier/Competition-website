package com.team5101.service.impl;


import com.team5101.mapper.SignUpMapper;
import com.team5101.pojo.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("signUpService")
@Transactional
public class SignUpService {
    @Autowired
    private SignUpMapper signUpMapper;

    public List<SignUp> findAllSignUpInfo(){
//        List<SignUp> signUpList = signUpMapper.getAll();
        return signUpMapper.getAll();}
}
