package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

public class TestExcelGenerator {
@Test
void testExcelGeneration() throws IOException {
    // Generate the Excel file
    ExcelGenerator.main(new String[0]);

    // Check if the file exists
    File file = new File("summary.xlsx");
    assertTrue(file.exists());

    // Read the generated file
    try (FileInputStream inputStream = new FileInputStream(file)) {
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet("summary");

        // Check the headings row
        Row headingsRow = sheet.getRow(0);
        assertNotNull(headingsRow);
        assertEquals("Page", headingsRow.getCell(0).getStringCellValue());
        assertEquals("No. of Images", headingsRow.getCell(1).getStringCellValue());
        assertEquals("No. of CSS", headingsRow.getCell(2).getStringCellValue());
        assertEquals("Scripts", headingsRow.getCell(3).getStringCellValue());
        assertEquals("No. of Links (Intra-Page)", headingsRow.getCell(4).getStringCellValue());
        assertEquals("No. of Links (Internal)", headingsRow.getCell(5).getStringCellValue());
        assertEquals("No. of Links (External)", headingsRow.getCell(6).getStringCellValue());

        // Check the data rows
        assertEquals("Page 1", sheet.getRow(1).getCell(0).getStringCellValue());
        assertEquals("10", sheet.getRow(1).getCell(1).getStringCellValue());
        assertEquals("2", sheet.getRow(1).getCell(2).getStringCellValue());
        assertEquals("5", sheet.getRow(1).getCell(3).getStringCellValue());
        assertEquals("10", sheet.getRow(1).getCell(4).getStringCellValue());
        assertEquals("3", sheet.getRow(1).getCell(5).getStringCellValue());

        assertEquals("Page 2", sheet.getRow(2).getCell(0).getStringCellValue());
        assertEquals("5", sheet.getRow(2).getCell(1).getStringCellValue());
        assertEquals("1", sheet.getRow(2).getCell(2).getStringCellValue());
        assertEquals("3", sheet.getRow(2).getCell(3).getStringCellValue());
        assertEquals("7", sheet.getRow(2).getCell(4).getStringCellValue());
        assertEquals("2", sheet.getRow(2).getCell(5).getStringCellValue());

        // Auto-sized columns
        for (int i = 0; i < 6; i++) {
            assertEquals(Sheet.class , sheet.getColumnWidth(i));
        }

        workbook.close();
    } catch (IOException e) {
        fail("An exception occurred while reading the generated file.");
    }
}
}

