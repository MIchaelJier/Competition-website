package com.team5101.xkjs.pojo;



public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer Authorization;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", Authorization=" + Authorization +
                '}';
    }
}
