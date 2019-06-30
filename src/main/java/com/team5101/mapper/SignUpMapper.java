package com.team5101.mapper;

import com.team5101.pojo.SignUp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface SignUpMapper {

     // 查询列表接口
    List<SignUp> getAllContestByJno(Integer j_id);
    //插入报名信息
    Integer addOne(SignUp signUp);
    int findInfo(SignUp signUp);

    List<SignUp> findSigUPInfo(Integer u_id);

    SignUp findContestInfo(String j_id);
}
