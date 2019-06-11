package com.team5101.pojo;


//用户
public class User {
    private Integer u_id;     //用户iD
    private String username;  //用户名
    private String password;  //密码
    private Integer Authorization; //权限： 1管理员  0 用户

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAuthorization() {
        return Authorization;
    }

    public void setAuthorization(Integer authorization) {
        Authorization = authorization;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", Authorization=" + Authorization +
                '}';
    }
}
