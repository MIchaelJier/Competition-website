package com.team5101.pojo;



public class ExcelClick {

    @ExcelColumn(value = "报名ID", col = 1)
    private String b_id;

    @ExcelColumn(value = "竞赛ID", col = 2)
    private String j_name;

    @ExcelColumn(value = "竞赛类型", col = 3)
    private String j_type;

    @ExcelColumn(value = "竞赛官网", col = 4)
    private String j_href;

    @ExcelColumn(value = "竞赛简介", col = 5)
    private String j_int;

    @ExcelColumn(value = "参数人姓名", col = 4)
    private String c_name;

    @ExcelColumn(value = "报名日期", col = 5)
    private String b_time;

    @ExcelColumn(value = "报名状态", col = 5)
    private String b_state;

    public String getB_id(){return b_id;}
    public String setB_id(String b_id){ return this.b_id=b_id; }

    public String getJ_name(){return j_name;}
    public String setJ_name(String j_name){ return this.j_name=j_name; }

    public String getJ_type(){return j_type;}
    public String setJ_type(String j_type){ return this.j_type=j_type; }

    public String getJ_href(){return j_href;}
    public String setJ_href(String j_href){ return this.j_href=j_href; }

    public String getC_name(){return c_name;}
    public String setC_name(String c_name){ return this.c_name=c_name; }

    public String getJ_int(){return j_int;}
    public String setJ_int(String j_int){ return this.j_int=j_int; }

    public String getB_time(){return b_time;}
    public String setB_time(String b_time){ return this.b_time=b_time; }

    public String getB_state(){return b_state;}
    public String setB_state(String b_state){ return this.b_state=b_state; }
}




