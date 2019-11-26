package com.example.codegenerator.code;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class GetExcel {

    public static void main(String[] args) {
        getData();
    }

    public static HashMap<String, Serializable> getData() {
        HashMap<String, Serializable> hashMap = new HashMap<>();

        try {
            //xls使用HSSFWorkbook
            Workbook workbook = new XSSFWorkbook(new File("excel/example.xlsx").getAbsoluteFile());

            Sheet sheet = workbook.getSheetAt(0);

            hashMap.put("className", sheet.getSheetName());

            Row nameRow = sheet.getRow(0);
            Row typeRow = sheet.getRow(1);
            Row commentRow = sheet.getRow(2);

            ArrayList<ExcelData> arrayList = new ArrayList<>();

            int nameFirstIndex = 0;
            int nameLastIndex = nameRow.getLastCellNum();
            for (;nameFirstIndex < nameLastIndex; nameFirstIndex++ ) {
                String name = nameRow.getCell(nameFirstIndex).toString();
                String type = typeRow.getCell(nameFirstIndex).toString().equals("int") ? "number" : typeRow.getCell(nameFirstIndex).toString();
                String comment = commentRow.getCell(nameFirstIndex).toString();
                ExcelData data = new ExcelData(name, type, comment);
                arrayList.add(data);
            }
            hashMap.put("fields", arrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hashMap;
    }

}
