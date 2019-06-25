package com.team5101.mapper;


import com.team5101.pojo.Competitor;
import com.team5101.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    /**
     * 查询用户
     * @param username
     * @param password
     * @return
     */
    public User findUser(@Param("username") String username,
                         @Param("password") String password);
    public Competitor findInfo(String u_sno);
    public Competitor updateOne(@Param("c_name")String c_name,@Param("c_gender")String c_gender,@Param("c_major")String c_major,@Param("c_phone")String c_phone,@Param("c_QQ")String c_QQ,@Param("c_sno")String c_sno);
}
