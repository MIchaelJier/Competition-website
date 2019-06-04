package com.team5101.service;



import com.team5101.mapper.UserMapper;
import com.team5101.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public User login(String username, String password){
        return userMapper.findUser(username,password);
    }
}
