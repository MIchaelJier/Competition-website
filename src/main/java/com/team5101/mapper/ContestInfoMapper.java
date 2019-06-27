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
    public List<ContestInfo> selectContestList(ContestInfo contestInfo);
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
