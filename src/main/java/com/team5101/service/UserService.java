package com.team5101.service;

import com.team5101.pojo.Competitor;
import com.team5101.pojo.User;


public interface UserService {
    public User login(String username, String password);
    public Competitor findInfo(String u_sno);


}
