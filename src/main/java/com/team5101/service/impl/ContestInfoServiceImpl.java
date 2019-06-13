package com.team5101.service.impl;

import com.team5101.mapper.ContestInfoMapper;
import com.team5101.pojo.ContestInfo;
import com.team5101.service.ContestInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("contestInfo")
@Transactional
public class ContestInfoServiceImpl implements ContestInfoService {

        @Autowired
        private ContestInfoMapper contestInfoMapper;

        public List<ContestInfo> findAllContestInfo(){
            //List<SignUp> signUpList = signUpMapper.getAll();
            return contestInfoMapper.getContestInfoAll();}
}


