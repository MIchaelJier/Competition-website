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
import java.util.List;

@Controller
public class ExcelController {
    @Autowired
    private SignUpMapper signUpMapper;
    //导出Excel
    @RequestMapping(value = "UserExcelDownloads", method = RequestMethod.GET)
    public void downloadAllClassmate(HttpServletResponse response, HttpServletRequest request) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");
        String j_id=request.getParameter("j_id");
        System.out.println(j_id);
        List<SignUp> signUps=signUpMapper.getAllContestByJno(Integer.valueOf(j_id));
        System.out.println(signUps);


        String fileName = "userinf"  + ".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据

        int rowNum = 1;

        String[] headers = { "学号", "姓名", "身份类型", "登录密码"};
        //headers表示excel表中第一行的表头

        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头

        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (SignUp signUp : signUps) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(signUp.getB_id());
            row1.createCell(1).setCellValue(signUp.getContestInfo().getJ_name());
            row1.createCell(2).setCellValue(signUp.getContestInfo().getJ_type());
            row1.createCell(3).setCellValue(signUp.getContestInfo().getJ_href());
            rowNum++;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
}