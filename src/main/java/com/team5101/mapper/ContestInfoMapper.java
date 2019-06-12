//package com.team5101.mapper;
//
//import com.team5101.pojo.ContestInfo;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Result;
//import org.apache.ibatis.annotations.Results;
//import org.apache.ibatis.annotations.Select;
//import org.springframework.stereotype.Repository;
//
//
//@Repository
//@Mapper
//public interface ContestInfoMapper {
//    @Select("SELECT * FROM x_contesttp where j_id=#{j_id}")
//    @Results({
//            @Result(property = "j_name" ,column = "c_name")
//    })
//    ContestInfo getComtestId(Integer j_id);
//}
