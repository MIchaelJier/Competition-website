package com.team5101.service;

import com.github.pagehelper.PageInfo;
import com.team5101.pojo.Notice;

import java.util.Date;

public interface NoticeService {
    //显示学生
    public PageInfo<Notice> findNoticeList(Integer page, Integer rows,
                                           String gg_title, String gg_fabuzhe,
                                           Date gg_date);
}
