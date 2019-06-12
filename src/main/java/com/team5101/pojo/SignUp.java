package com.team5101.pojo;


import java.util.Date;

//报名实体类
public class SignUp {
    private Integer b_id;
    private Integer j_id;
    private Integer u_id;
    private Date b_time;
    private String b_state;
    private Competitor competitor;
    private ContestInfo contestInfo;

    public Competitor getCompetitor() {
        return competitor;
    }

    public void setCompetitor(Competitor competitor) {
        this.competitor = competitor;
    }

    public ContestInfo getContestInfo() {
        return contestInfo;
    }

    public void setContestInfo(ContestInfo contestInfo) {
        this.contestInfo = contestInfo;
    }

    public Integer getB_id() {
        return b_id;
    }

    public void setB_id(Integer b_id) {
        this.b_id = b_id;
    }

    public Integer getJ_id() {
        return j_id;
    }

    public void setJ_id(Integer j_id) {
        this.j_id = j_id;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public Date getB_time() {
        return b_time;
    }

    public void setB_time(Date b_time) {
        this.b_time = b_time;
    }

    public String getB_state() {
        return b_state;
    }

    public void setB_state(String b_state) {
        this.b_state = b_state;
    }
}
