package com.team5101.pojo;


//报名实体类
public class SignUp {
    private Integer b_id;
    private Integer j_id;
    private Integer c_id;
    private String j_name;
    private String b_time;
    private String b_state;
    private Competitor competitor;
    private ContestInfo contestInfo;

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

    public String getJ_name() {
        return j_name;
    }

    public void setJ_name(String j_name) {
        this.j_name = j_name;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getB_time() {
        return b_time;
    }

    public void setB_time(String b_time) {
        this.b_time = b_time;
    }

    public String getB_state() {
        return b_state;
    }

    public void setB_state(String b_state) {
        this.b_state = b_state;
    }

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

    @Override
    public String toString() {
        return "SignUp{" +
                "b_id=" + b_id +
                ", j_id=" + j_id +
                ", c_id=" + c_id +
                ", b_time='" + b_time + '\'' +
                ", b_state='" + b_state + '\'' +
                ", competitor=" + competitor +
                ", contestInfo=" + contestInfo +
                '}';
    }
}
