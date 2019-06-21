package com.team5101.service;

import com.github.pagehelper.PageInfo;
import com.team5101.pojo.Notice;

import java.util.Date;
import java.util.List;

public interface NoticeService {
    //显示学生
    public PageInfo<Notice> findNoticeList(Integer page, Integer rows,
                                           String gg_title, String gg_fabuzhe,
                                           Date gg_date);

    //标题查重
    public int  getNoticeByTitle(String gg_title);
    //添加通知
    public int createNotice(Notice notice);
    //根据Title查内容
    public Notice getNoticeByT(String gg_title);
    //修改通知
    public int updateNotice(Notice notice);
    //删除通知
    public int deleteNotice(Integer gg_id);
    //批量删除通知
    public void batchDeletes(List delList);



}
