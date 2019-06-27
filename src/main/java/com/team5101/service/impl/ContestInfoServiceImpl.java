package com.team5101.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team5101.mapper.ContestInfoMapper;
import com.team5101.pojo.ContestInfo;
import com.team5101.service.ContestInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service("contestInfo")
@Transactional
public class ContestInfoServiceImpl implements ContestInfoService {

        @Autowired
        private ContestInfoMapper contestInfoMapper;

        public List<ContestInfo> findAllContestInfo(){
            //List<SignUp> signUpList = signUpMapper.getAll();
            return contestInfoMapper.getContestInfoAll();}

        @Override
        public PageInfo<ContestInfo> findContestList(Integer page, Integer rows, String j_name, String j_type, String j_introduction, String j_href, Date j_starttime, Date j_endtime) {
            ContestInfo contestInfo=new ContestInfo();
            //判断 j_name
            if(StringUtils.isNotBlank(j_name)) {
                contestInfo.setJ_name(j_name);
            }
            //判断j_type
            if(StringUtils.isNotBlank(j_type)) {
                contestInfo.setJ_type(j_type);
            }
            //判断j_introduction
            if(StringUtils.isNotBlank(j_introduction)) {
                contestInfo.setJ_int(j_introduction);
            }
            //判断j_href
            if(StringUtils.isNotBlank(j_href)) {
                contestInfo.setJ_href(j_href);
            }
            //判断 j_starttime
            if(j_starttime!=null) {
               contestInfo.setJ_starttime(j_starttime);
            }
            //判断 j_endtime
            if(j_endtime!=null) {
                contestInfo.setJ_endtime(j_endtime);
            }

            // System.out.println(page+"\n"+rows);
            PageHelper.startPage(page, rows);
            List<ContestInfo> contestInfos = contestInfoMapper.selectContestList(contestInfo);
            PageInfo<ContestInfo> pageInfo = new PageInfo<>(contestInfos);
            return pageInfo;
        }

        @Override
        public int getContestByName(String j_name) {
            return contestInfoMapper.getContestByName(j_name);
        }

        @Override
        public int createContest(ContestInfo contestInfo) {
            return contestInfoMapper.createContest(contestInfo);
        }

        @Override
        public ContestInfo getContestById(Integer j_id) {
            return contestInfoMapper.getContestById(j_id);
        }

        @Override
        public int updateContest(ContestInfo contestInfo) {
            return contestInfoMapper.updateContest(contestInfo);
        }

        @Override
        public int deleteContest(Integer j_id) {
            return contestInfoMapper.deleteContest(j_id);
        }
}


