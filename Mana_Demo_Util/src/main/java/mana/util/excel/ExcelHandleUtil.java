package mana.util.excel;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelHandleUtil {

    public static List<List<Object>> getExcelContent(String filePath,String fileName,boolean isFirstLine) {
        Workbook wb = null;
        Sheet sheet = null;
        Row row = null;
        wb = readExcel(filePath + "\\" + fileName);
        List<List<Object>> resultList = new ArrayList<>();
        if (wb != null) {
            //用来存放表中数据
            //获取第一个sheet
            sheet = wb.getSheetAt(0);
            //获取最大行数
            int rownum = sheet.getPhysicalNumberOfRows();
            //获取第一行
            row = sheet.getRow(0);
            //获取最大列数
            int colnum = row.getPhysicalNumberOfCells();
            int i;
            if(isFirstLine){
                i = 0;
            }else{
                i = 1;
            }
            for (; i < rownum; i++) {
                List<Object> list = new ArrayList<>();
                Map<String, String> map = new LinkedHashMap<String, String>();
                row = sheet.getRow(i);
                if (row != null) {
                    for (int j = 0; j < colnum; j++) {
                        list.add(j, getCellFormatValue(row.getCell(j)));
                    }
                } else {
                    break;
                }
                resultList.add(list);
            }
        }
        return resultList;
    }

    //读取excel
    public static Workbook readExcel(String filePath) {
        Workbook wb = null;
        if (filePath == null) {
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if (".xls".equals(extString)) {
                return wb = new HSSFWorkbook(is);
            } else if (".xlsx".equals(extString)) {
                return wb = new XSSFWorkbook(is);
            } else {
                return wb = null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

    public static Object getCellFormatValue(Cell cell) {
        Object cellValue = null;
        if (cell != null) {
            //判断cell类型
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC: {
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                }
                case Cell.CELL_TYPE_FORMULA: {
                    //判断cell是否为日期格式
                    if (DateUtil.isCellDateFormatted(cell)) {
                        //转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    } else {
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING: {
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        } else {
            cellValue = "";
        }
        return cellValue;
    }

    public static void main(String[] args) {
        String filePath = "E:\\data";
        String fileName = "test.xlsx";
        List<List<Object>> excelContent = ExcelHandleUtil.getExcelContent(filePath,fileName,true);
        for (int i = 0; i < excelContent.size(); i++) {
            for (int j = 0; j < excelContent.get(i).size(); j++) {
                System.out.println(excelContent.get(i).get(j).toString());
            }
        }
    }
}
