package com.team5101.pojo;

//参赛人实体类
public class Competitor {
    private Integer c_id;
    private String c_sno;
    private String c_name;
    private String c_gender;
    private String c_major;
    private String c_phone;
    private String c_QQ;

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_sno() {
        return c_sno;
    }

    public String setC_sno(String c_sno) {
        this.c_sno = c_sno;
        return c_sno;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_gender() {
        return c_gender;
    }

    public void setC_gender(String c_gender) {
        this.c_gender = c_gender;
    }

    public String getC_major() {
        return c_major;
    }

    public void setC_major(String c_major) {
        this.c_major = c_major;
    }

    public String getC_phone() {
        return c_phone;
    }

    public void setC_phone(String c_phone) {
        this.c_phone = c_phone;
    }

    public String getC_QQ() {
        return c_QQ;
    }

    public void setC_QQ(String c_QQ) {
        this.c_QQ = c_QQ;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "c_id=" + c_id +
                ", c_sno='" + c_sno + '\'' +
                ", c_name='" + c_name + '\'' +
                ", c_gender='" + c_gender + '\'' +
                ", c_major='" + c_major + '\'' +
                ", c_phone='" + c_phone + '\'' +
                ", c_QQ='" + c_QQ + '\'' +
                '}';
    }
}
