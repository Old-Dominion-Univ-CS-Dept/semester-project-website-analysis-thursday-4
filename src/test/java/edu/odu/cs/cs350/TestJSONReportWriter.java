package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class TestJSONReportWriter {
    
    @Test
    public void testDefaultConstructor() {
        // Create a JSONReportWriter instance
        JSONReportWriter writer = new JSONReportWriter();

        // Verify that the output file is created and is not null
        File outputFile = writer.getOutputFile();
        assertNotNull(outputFile);
        assertEquals("src/main/data/report.json", outputFile.getPath());
    }

    @Test
    public void testNonDefaultConstructor() {
   
        File customOutputFile = new File("src/main/data/custom-report.json");
        JSONReportWriter writer = new JSONReportWriter(customOutputFile);

        File outputFile = writer.getOutputFile();
        assertNotNull(outputFile);
        assertEquals(customOutputFile.getPath(), outputFile.getPath());
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

     // Verify the path of the output file
     assertTrue(outputFile.getPath().contains("src/main/data/report.json"));
}

    @Test
    public void testWriteReport() {
        // Create a JSONReportWriter instance
        JSONReportWriter writer = new JSONReportWriter();

                // Load dummy data from JSON file
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> reportData = null;
        try {
            reportData = mapper.readValue(
                new File("src/test/resources/testJsonReport.json"),
                new TypeReference<Map<String, Object>>(){}
            );
        } catch (IOException e) {
            fail("Error loading dummy data: " + e.getMessage());
        }

        // Write the report
        writer.writeReport(reportData);

        // Read the output file and check its contents
        try (BufferedReader reader = new BufferedReader(new FileReader(writer.getOutputFile()))) {
            String line = reader.readLine();
            assertTrue(line.contains("\"basePath\":\"/path/to/local/copy\""));
        } catch (IOException e) {
            fail("Error reading output file: " + e.getMessage());
        }
    }
}