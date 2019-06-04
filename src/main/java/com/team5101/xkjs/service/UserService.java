package com.team5101.xkjs.service;



import com.team5101.xkjs.mapper.UserMapper;
import com.team5101.xkjs.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public User login(String username, String password){
        return userMapper.findUser(username,password);
    }
}
