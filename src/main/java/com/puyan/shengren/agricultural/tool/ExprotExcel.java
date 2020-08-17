package com.puyan.shengren.agricultural.tool;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExprotExcel {

    /**
     *@Description: exportAll方法是导出通用方法
     *@param: bankHuizhiList   传入需要导出的数据 ；biaotoulsit 传入需要导出数据的表头，另-两个集合需要数量相同
     *@return:
     *@auther: yuhua
     *@date: 2019/8/8 15:18
     */
//	@ResponseBody
    public static void exportAll(List<Map<String,Object>> bankHuizhiList,Map<String,Object> biaotoulsit,HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
        //  yyyyMMdd 格式
        Map<String,Object>  errormap=new HashMap<>();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String proMonth=simpleDateFormat.format(new Date());
        // 生成提示信息
        response.setContentType("application/vnd.ms-excel");
        String fileName = null;
        OutputStream fOut = null;
       // List<Map<String,Object>> bankHuizhiList = zzfZufangHetongBusiness.queryZufangHetongInfoBySeaInfo(zzfZufangHetong);

        try {
            fOut = response.getOutputStream();
            fileName = java.net.URLEncoder.encode("信息_"  + proMonth, "UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(),"iso-8859-1") + ".xlsx");
            int rowCount = 1;

            // 产生工作簿对象
            XSSFWorkbook workbook = new XSSFWorkbook();
            //产生工作表对象
            XSSFSheet sheet = workbook.createSheet(proMonth + "_信息");
            sheet.autoSizeColumn(10);
            //bankHuizhiList.get(0).size()在map中有多少条数据创建多少个列， 需要控制select 查询返回的列数
            for (int i=0;i<biaotoulsit.size();i++){
                sheet.setColumnWidth(i,5120);
            }

            sheet.createFreezePane(0, 2, 0, 2); // 冻结

            XSSFCellStyle style2 = workbook.createCellStyle();
            style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);  // 设置单元格风格，居中对齐.
            style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

            //边框填充
            style2.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
            style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
            style2.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
            style2.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框

            XSSFFont headerFont1 = workbook.createFont(); // 创建字体样式
            headerFont1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗
            headerFont1.setFontName("黑体"); // 设置字体类型
            headerFont1.setFontHeightInPoints((short) 20); // 设置字体大小
            style2.setFont(headerFont1); // 为标题样式设置字体样式

 XSSFRow row1 = sheet.createRow((int) 0);
            row1.setHeightInPoints(50);// 设备标题的高度
            XSSFCell cell1 = row1.createCell(0);// 创建标题第一列
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,bankHuizhiList.get(0).size())); // 合并第0到第 结尾 列


 cell1.setCellValue("信息"); // 设置值标题
            cell1.setCellStyle(style2);// 设置标题样式


            XSSFFont bold  = workbook.createFont();
            bold.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗

            XSSFCellStyle titleStyle = workbook.createCellStyle();
            titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//左右居中
            titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中

            titleStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);//前景颜色
            titleStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);//填充方式，前色填充
            //边框填充
            titleStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
            titleStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
            titleStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
            titleStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框

            XSSFFont diyihangFont = workbook.createFont(); // 创建字体样式
            diyihangFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗
            diyihangFont.setFontName("黑体"); // 设置字体类型
            diyihangFont.setFontHeightInPoints((short) 12); // 设置字体大小
            titleStyle.setFont(diyihangFont); // 为标题样式设置字体样式

            XSSFRow row = sheet.createRow(rowCount++);
            row.setHeightInPoints(30);
            XSSFCell cell=null;
            int num=0;
            for(String key : biaotoulsit.keySet()){
                cell= row.createCell(num);//创建一列
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);//行 类型  字符串
                cell.setCellStyle(titleStyle);//列风格
                cell.setCellValue(key);//单元格的值
                num++;
            }
            XSSFCellStyle dataStyle = workbook.createCellStyle(); // 样式对象
            dataStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);//左右居中
            dataStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//上下居中

            //边框填充
            dataStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框
            dataStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
            dataStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
            dataStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框
            dataStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);

            XSSFCellStyle dataRigStyle = workbook.createCellStyle(); // 样式对象
            dataRigStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);//左右居中
            dataRigStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//上下居中

            //边框填充
            dataRigStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框
            dataRigStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
            dataRigStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
            dataRigStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框
            dataRigStyle.setAlignment(XSSFCellStyle.ALIGN_RIGHT);

            XSSFCellStyle dataLefStyle = workbook.createCellStyle(); // 样式对象
            dataLefStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//左右居中
            dataLefStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中

            //边框填充
            dataLefStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框
            dataLefStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
            dataLefStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
            dataLefStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框
            dataLefStyle.setAlignment(XSSFCellStyle.ALIGN_LEFT);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if(bankHuizhiList != null && !bankHuizhiList.isEmpty()&&bankHuizhiList.size()>0) {
                int indexs = 1;//序号列计数值
                for(int i=0;i<bankHuizhiList.size();i++) {
                    row = sheet.createRow(rowCount++);//每循环一次换行
                    int cellnum=0;//没遍历一列换列计次
 biaotoulsit.entrySet().forEach(listmap -> {
                    });


                        for (Object value1 : biaotoulsit.values()) { //循环列名与数据库对照取出value的值

                        if(value1.toString()=="1"||value1.toString().equals("1")){//根据参数判断为序号列
                            cell = row.createCell(cellnum);             //添加一列
                            cell.setCellType(XSSFCell.CELL_TYPE_STRING);//设置单元格数据类型
                            cell.setCellValue(indexs);//输入单元格的值
                            cell.setCellStyle(dataStyle);//数据输入单元格
                            indexs += 1;
                        }else {

                            if (bankHuizhiList.get(i).get(value1) != null && bankHuizhiList.get(i).get(value1) != "" && value1.toString() != "1" && !value1.toString().equals("1")) {
                                //if判断根据数据库中取出值是否为空，防止报错
                                cell = row.createCell(cellnum);
                                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                                cell.setCellValue(bankHuizhiList.get(i).get(value1).toString());
                                cell.setCellStyle(dataStyle);
                            } else {
                                cell = row.createCell(cellnum);
                                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                                cell.setCellValue("");
                                cell.setCellStyle(dataStyle);
                            }
                        }
                        cellnum++;
                    }

                }
            }

            workbook.write(fOut);

        }catch (UnsupportedEncodingException e){
            errormap.put("error",e.getMessage());
        } catch (IOException e) {
            errormap.put("error",e.getMessage());
        } finally {
            try {
                fOut.flush();
                fOut.close();
            } catch (IOException e) {

                errormap.put("error",e.getMessage());
            }

        }

    }
}
