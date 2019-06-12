package com.team5101.mapper;


import com.team5101.pojo.Competitor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public  interface CompetitorMapper {
    @Select("SELECT * FROM x_contestm where c_id=#{u_id}")
    @Results({
            @Result(property = "c_name" ,column = "c_name")
    })
    Competitor getCompetitorId(Integer u_id);
}
