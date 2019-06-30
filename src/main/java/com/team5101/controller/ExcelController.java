package com.team5101.controller;


import com.team5101.mapper.SignUpMapper;
import com.team5101.pojo.SignUp;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ExcelController {
    @Autowired
    private SignUpMapper signUpMapper;
    //导出Excel
    @RequestMapping(value = "/ExcelDownloads", method = RequestMethod.GET)
    public void downloadAllClassmate(HttpServletResponse response, HttpServletRequest request) throws IOException, ParseException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");
        String j_id=request.getParameter("j_id");
//        String j_id="4";
        List<SignUp> signUps=signUpMapper.getAllContestByJno(Integer.valueOf(j_id));
        System.out.println(j_id);


        String fileName = signUpMapper.findContestInfo(j_id).getContestInfo().getJ_name()  + "报名信息表.xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据

        int rowNum = 1;

        String[] headers = { "序号", "竞赛名称", "竞赛类型", "竞赛官网", "竞赛竞赛简介", "参赛人", "报名时间", "报名状态"};
        //headers表示excel表中第一行的表头

        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头

        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        //在表中存放查询到的数据放入对应的列
        int a=1;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (SignUp signUp : signUps) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(a);
            row1.createCell(1).setCellValue(signUp.getContestInfo().getJ_name());
            row1.createCell(2).setCellValue(signUp.getContestInfo().getJ_type());
            row1.createCell(3).setCellValue(signUp.getContestInfo().getJ_href());
            row1.createCell(4).setCellValue(signUp.getContestInfo().getJ_int());
            row1.createCell(5).setCellValue(signUp.getCompetitor().getC_name());
            row1.createCell(6).setCellValue(sdf.format(signUp.getB_time()));
            row1.createCell(7).setCellValue(signUp.getB_state());
            rowNum++;
            a++;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"utf-8"));
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
}