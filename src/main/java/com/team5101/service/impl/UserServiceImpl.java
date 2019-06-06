package com.team5101.service.impl;



import com.team5101.mapper.UserMapper;
import com.team5101.pojo.User;
import com.team5101.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password){
        return userMapper.findUser(username,password);
    }
}
