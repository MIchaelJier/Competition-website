package com.team5101.mapper;

import com.team5101.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface NoticeMapper {
    //显示通知
    public List<Notice> selectNoticeList(Notice notice);

    //标题查重
    public int  getNoticeByTitle(String gg_title);

    //添加通知
    public int createNotice(Notice notice);

    //根据title查内容
    public Notice getNoticeByT(String gg_title);

    //修改通知
    public int updateNotice(Notice notice);

    //删除通知
    public int deleteNotice(Integer gg_id);

    //批量删除通知
    public void batchDeletes(List delList);

}
