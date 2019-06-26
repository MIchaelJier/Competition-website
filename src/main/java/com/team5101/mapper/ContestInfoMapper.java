package com.team5101.mapper;

import com.team5101.pojo.ContestInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface ContestInfoMapper {

    //显示竞赛信息
    List<ContestInfo> getContestInfoAll();

    //竞赛名查重
    public int  getNoticeByTitle(String j_name);

    //添加竞赛
    public int createNotice(ContestInfo contestInfo);

    //根据id查内容
    public ContestInfo getNoticeByT(int  j_id);

    //修改竞赛
    public int updateNotice(ContestInfo contestInfo);

    //删除竞赛
    public int deleteNotice(Integer gg_id);

    //批量删除通知
    public void batchDeletes(List delList);


}
