package com.team5101.pojo;

public class Group {
    private Integer g_id;
    private String g_name;
    private String g_sn1;
    private String g_sn2;
    private String g_sn3;
    private String g_sn4;
    private String g_code;

    public String getG_code() {
        return g_code;
    }

    public void setG_code(String g_code) {
        this.g_code = g_code;
    }

    public Integer getG_id() {
        return g_id;
    }

    public void setG_id(Integer g_id) {
        this.g_id = g_id;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public String getG_sn1() {
        return g_sn1;
    }

    public void setG_sn1(String g_sn1) {
        this.g_sn1 = g_sn1;
    }

    public String getG_sn2() {
        return g_sn2;
    }

    public void setG_sn2(String g_sn2) {
        this.g_sn2 = g_sn2;
    }

    public String getG_sn3() {
        return g_sn3;
    }

    public void setG_sn3(String g_sn3) {
        this.g_sn3 = g_sn3;
    }

    public String getG_sn4() {
        return g_sn4;
    }

    public void setG_sn4(String g_sn4) {
        this.g_sn4 = g_sn4;
    }

    @Override
    public String toString() {
        return "Group{" +
                "g_id=" + g_id +
                ", g_name='" + g_name + '\'' +
                ", g_sn1='" + g_sn1 + '\'' +
                ", g_sn2='" + g_sn2 + '\'' +
                ", g_sn3='" + g_sn3 + '\'' +
                ", g_sn4='" + g_sn4 + '\'' +
                ", g_code='" + g_code + '\'' +
                '}';
    }
}
