package edu.odu.cs.cs350;

import java.io.IOException;
import java.io.FileOutputStream;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import java.util.AbstractList;
//import java.util.List;

// Create data for the spreadsheet
// Populate the sheet with data
// Write the workbook to a file

public class ExcelGenerator {
    public static void main(String[] args) {
        // Create a new workbook
        Workbook workbook = new XSSFWorkbook();
        // Create a new sheet
        Sheet sheet = workbook.createSheet("ExcelGen");

        // Create the headings row
        Row headingsRow = sheet.createRow(0);
        headingsRow.createCell(0).setCellValue("Page");
        headingsRow.createCell(1).setCellValue("Number of Images");
        headingsRow.createCell(2).setCellValue("Number of CSS Scripts");
        headingsRow.createCell(3).setCellValue("Number of Links (Intra-Page)");
        headingsRow.createCell(4).setCellValue("Number of Links (Internal)");
        headingsRow.createCell(5).setCellValue("Number of Links (External)");

        // Add data for internal pages
        String[][] data = {
                {"Page 1", "10", "2", "5", "10", "3"},
                {"Page 2", "5", "1", "3", "7", "2"}
        };

        int rowCount = 1;
        for (String[] rowData : data) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            for (String cellData : rowData) {
                row.createCell(columnCount++).setCellValue(cellData);
            }
        }

        // Auto-size the columns
        for (int i = 0; i < 6; i++) {
            sheet.autoSizeColumn(i);
        }
              
        // Write the workbook to a file
        try (FileOutputStream outputStream = new FileOutputStream("ExcelGen.xlsx")) {
            workbook.write(outputStream);
            System.out.println("Excel file generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
