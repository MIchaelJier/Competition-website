package com.team5101.service;

import com.team5101.pojo.Competitor;
import com.team5101.pojo.User;


//https://www.cnblogs.com/1315925303zxz/p/7364552.html
public interface UserService {
    public User login(String username, String password);
    Competitor findInfo(String u_sno);

}
