package com.team5101.mapper;

import com.team5101.pojo.ContestInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface ContestInfoMapper {
    List<ContestInfo> getContestInfoAll();
}
