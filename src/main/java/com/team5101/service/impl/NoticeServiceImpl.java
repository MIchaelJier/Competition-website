package com.team5101.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team5101.mapper.NoticeMapper;
import com.team5101.pojo.Notice;
import com.team5101.service.NoticeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service( "noticeService")
@Transactional

public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;


    @Override
    public PageInfo<Notice> findNoticeList(Integer page, Integer rows, String gg_title, String gg_fabuzhe, Date gg_date) {
        Notice notice=new Notice();
        //判断gg_title
        if(StringUtils.isNotBlank(gg_title)) {
            notice.setGg_title(gg_title);
        }
        //判断fabuzhe
        if(StringUtils.isNotBlank(gg_fabuzhe)) {
            notice.setGg_fabuzhe(gg_fabuzhe);
        }

        //判断gg_date
        if(gg_date!=null) {
            notice.setGg_date(gg_date);

        }


        System.out.println(page+"\n"+rows);
        PageHelper.startPage(page, rows);
        List<Notice> notices = noticeMapper.selectNoticeList(notice);
        PageInfo<Notice> pageInfo = new PageInfo<>(notices);
        return pageInfo;

    }
}
