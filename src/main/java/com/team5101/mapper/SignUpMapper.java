package com.team5101.mapper;

import com.team5101.pojo.SignUp;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface SignUpMapper {

//    查询列表接口
@Select("SELECT * FROM x_contesttp")
@Results({
        @Result(property = "u_id", column = "c_id",
                one = @One(select = "com.team5101.mapper.CompetitorMapper.getCompetitorId")),
        @Result(property = "j_id", column = "j_id",
                many = @Many(select = "com.team5101.mapper.ContestInfoMapper")),

        //column代表将该属性作为参数传入,property代表将查询出来的数据交给该属性
})
    List<SignUp> getAll();
}
