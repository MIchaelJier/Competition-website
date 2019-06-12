package com.team5101.mapper;

import com.team5101.pojo.ContestInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface ContestInfoMapper {
    ContestInfo getContestById(Integer j_id);
}
