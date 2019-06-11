package com.team5101.pojo;

import java.util.Date;

//公告
public class Notice {
    private Integer gg_id;//发布id
    private String  gg_title;//发布标题
    private String gg_content;//发布内容
    private Date gg_date;//发布日期
    private String gg_fabuzhe;//发布者

    public Integer getGg_id() {
        return gg_id;
    }

    public void setGg_id(Integer gg_id) {
        this.gg_id = gg_id;
    }

    public String getGg_title() {
        return gg_title;
    }

    public void setGg_title(String gg_title) {
        this.gg_title = gg_title;
    }

    public String getGg_content() {
        return gg_content;
    }

    public void setGg_content(String gg_content) {
        this.gg_content = gg_content;
    }

    public Date getGg_date() {
        return gg_date;
    }

    public void setGg_date(Date gg_date) {
        this.gg_date = gg_date;
    }

    public String getGg_fabuzhe() {
        return gg_fabuzhe;
    }

    public void setGg_fabuzhe(String gg_fabuzhe) {
        this.gg_fabuzhe = gg_fabuzhe;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "gg_id=" + gg_id +
                ", gg_title='" + gg_title + '\'' +
                ", gg_content='" + gg_content + '\'' +
                ", gg_date=" + gg_date +
                ", gg_fabuzhe='" + gg_fabuzhe + '\'' +
                '}';
    }
}
