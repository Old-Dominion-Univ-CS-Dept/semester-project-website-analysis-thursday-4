package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestJSONReportWriter {

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