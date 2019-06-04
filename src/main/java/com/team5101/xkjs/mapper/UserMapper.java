package com.team5101.xkjs.mapper;


import com.team5101.xkjs.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    /**
     * 查询用户
     * @param username
     * @param password
     * @return
     */
    public User findUser(@Param("username") String username,
                         @Param("password") String password);
}
