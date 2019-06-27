package com.team5101.service;

import com.github.pagehelper.PageInfo;
import com.team5101.pojo.ContestInfo;

import java.util.Date;
import java.util.List;

public interface ContestInfoService {
    List<ContestInfo> findAllContestInfo();

    //显示学生
    public PageInfo<ContestInfo> findContestList(Integer page, Integer rows,
                                                 String  j_name, String  j_type, String  j_introduction, String  j_href,
                                                 Date j_starttime, Date j_endtime);
    //j_id,j_name,j_type,j_introduction,j_href,j_starttime,j_endtime


    //竞赛名查重
    public int  getContestByName(String j_name);

    //添加竞赛
    public int createContest(ContestInfo contestInfo);

    //根据id查内容
    public ContestInfo getContestById(Integer  j_id);

    //修改竞赛
    public int updateContest(ContestInfo contestInfo);

    //删除竞赛
    public int deleteContest(Integer j_id);

    //批量删除通知
    //public void batchDeletes(List delList);


}
