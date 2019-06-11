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
}
