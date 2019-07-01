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
    //验证
    public Integer CheckUser(@Param("username") String username, @Param("password") String password);
    public Competitor findInfo(String u_sno);
    Integer  updateOne(Competitor competitor);

    //修改密码
    Integer updatePassword(@Param("username") String username,
                        @Param("password") String password);

}
