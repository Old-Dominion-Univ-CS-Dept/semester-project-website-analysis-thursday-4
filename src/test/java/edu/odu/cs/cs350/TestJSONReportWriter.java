package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestJSONReportWriter {
    
    @Test
    public void testConstructor() {
        // Create a JSONReportWriter instance
        JSONReportWriter writer = new JSONReportWriter();

        // Verify that the output file is created and is not null
        File outputFile = writer.getOutputFile();
        assertNotNull(outputFile);
        assertTrue(outputFile.exists());
    }

    @Test
public void testGetOutputFile() {
    // Create a JSONReportWriter instance
    JSONReportWriter writer = new JSONReportWriter();

    // Get the output file
    File outputFile = writer.getOutputFile();

    // Verify that the output file is not null
    assertNotNull(outputFile);

    // Verify that the output file name is "report.json"
    assertEquals("report.json", outputFile.getName());
}

    @Test
    public void testWriteReport() {
        // Create a JSONReportWriter instance
        JSONReportWriter writer = new JSONReportWriter();

        // Create some dummy report data
        Map<String, Object> reportData = new HashMap<>();
        reportData.put("testKey", "testValue");

        // Write the report
        writer.writeReport(reportData);

        // Read the output file and check its contents
        try (BufferedReader reader = new BufferedReader(new FileReader("report.json"))) {
            String line = reader.readLine();
            assertTrue(line.contains("\"testKey\":\"testValue\""));
        } catch (IOException e) {
            fail("Error reading output file: " + e.getMessage());
        }
    }
}