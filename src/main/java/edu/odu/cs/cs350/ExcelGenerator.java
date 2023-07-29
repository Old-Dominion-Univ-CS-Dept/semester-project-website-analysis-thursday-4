package edu.odu.cs.cs350;

import java.io.FileOutputStream;
import java.io.IOException;
 import java.io.File;
 import java.io.FilenameFilter;
 import java.io.*;

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
    public static void main(String[] args) throws IOException {
        // Create a new workbook
        Workbook workbook = new XSSFWorkbook();
        // Create a new sheet
        Sheet sheet = workbook.createSheet("summary");

  
        // Create the headings row
        Row headingsRow = sheet.createRow(0);
        headingsRow.createCell(0).setCellValue("Page");
        headingsRow.createCell(1).setCellValue("No. of Images");
        headingsRow.createCell(2).setCellValue("No. of  CSS");
        headingsRow.createCell(3).setCellValue("Scripts");
        headingsRow.createCell(4).setCellValue("No. of Links (Intra-Page)");
        headingsRow.createCell(5).setCellValue("No. of Links (Internal)");
        headingsRow.createCell(6).setCellValue("No. of Links (External)");

        // Add data for internal pages
        String[][] data = {
                {"Page 1", "10", "2", "5", "10", "3", "11"},
                {"Page 2", "5", "1", "3", "7", "2", "4"}
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
        try (FileOutputStream outputStream = new FileOutputStream("summary.xlsx")) {
            workbook.write(outputStream);

            //added this to output filename to console.
            System.out.println(outputStream + "/n");

            System.out.println("Excel file generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    workbook.close();

    }
    
}
