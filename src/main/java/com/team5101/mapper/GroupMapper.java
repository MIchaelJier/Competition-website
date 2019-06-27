package com.team5101.mapper;


import com.team5101.pojo.Group;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GroupMapper {
    //创建小组
    Group addGroup(Group group);
}
