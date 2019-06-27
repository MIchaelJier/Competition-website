package com.team5101.pojo;


import java.util.Date;

//竞赛信息实体类
public class ContestInfo {
    private Integer j_id;
    private String j_name;
    private String j_type;
    private String j_int;
    private String j_href;
    private Date j_starttime;
    private Date j_endtime;

    public Date getJ_starttime() {
        return j_starttime;
    }

    public void setJ_starttime(Date j_starttime) {
        this.j_starttime = j_starttime;
    }

    public Date getJ_endtime() {
        return j_endtime;
    }

    public void setJ_endtime(Date j_endtime) {
        this.j_endtime = j_endtime;
    }

    public Integer getJ_id() {
        return j_id;
    }

    public void setJ_id(Integer j_id) {
        this.j_id = j_id;
    }

    public String getJ_name() {
        return j_name;
    }

    public void setJ_name(String j_name) {
        this.j_name = j_name;
    }

    public String getJ_type() {
        return j_type;
    }

    public void setJ_type(String j_type) {
        this.j_type = j_type;
    }

    public String getJ_int() {
        return j_int;
    }

    public void setJ_int(String j_int) {
        this.j_int = j_int;
    }

    public String getJ_href() {
        return j_href;
    }

    public void setJ_href(String j_href) {
        this.j_href = j_href;
    }

    @Override
    public String toString() {
        return "ContestInfo{" +
                "j_id=" + j_id +
                ", j_name='" + j_name + '\'' +
                ", j_type='" + j_type + '\'' +
                ", j_int='" + j_int + '\'' +
                ", j_href='" + j_href + '\'' +
                ", j_starttime=" + j_starttime +
                ", j_endtime=" + j_endtime +
                '}';
    }
}
