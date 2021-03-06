package com.team5101.pojo;


import java.io.Serializable;

public class User implements Serializable {
    private Integer u_id;
    private String username;
    private String password;
    private Integer role;
    private String u_sno;

    public String getU_sno() {
        return u_sno;
    }

    public void setU_sno(String u_sno) {
        this.u_sno = u_sno;
    }

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

    public Integer getRole() {
        return role;
    }
    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", u_sno=" + u_sno +
                '}';
    }
}
