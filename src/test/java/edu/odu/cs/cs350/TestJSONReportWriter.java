package edu.odu.cs.cs350;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import com.cedarsoftware.util.io.JsonWriter;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TestJSONReportWriter {
    private JSONReportWriter writer;
    private File outputFile;

    @BeforeEach
    public void setUp() {
        outputFile = new File("src/main/data/report.json");
        writer = new JSONReportWriter(outputFile);
    }

    @Test
    public void testDefaultConstructor() {
       
        // Verify that the output file is created and is not null
        File outputFile = writer.getOutputFile();
        assertThat(outputFile, is(notNullValue()));
        assertThat(outputFile.getPath(), is(equalTo("src/main/data/report.json")));
    }

    @Test
    public void testNonDefaultConstructor() {
   
        File customOutputFile = new File("src/main/data/custom-report.json");
        JSONReportWriter writer = new JSONReportWriter(customOutputFile);

        File outputFile = writer.getOutputFile();
        assertThat(outputFile, is(notNullValue()));
        assertThat(outputFile.getPath(), is(equalTo(customOutputFile.getPath())));
    }


    

    @Test
    public void testGetOutputFile() {
        // Get the output file
        File outputFile = writer.getOutputFile();

        // Verify that the output file is not null
        assertThat(outputFile, is(notNullValue()));

        // Verify that the output file name is "report.json"
        assertThat(outputFile.getName(), is(equalTo("report.json")));

        // Verify the path of the output file
        assertThat(outputFile.getPath(), containsString("src/main/data/report.json"));
    }

    @Test
    public void testWriteReport() throws IOException {
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
        try {
            writer.writeReport(reportData);
        } catch (IOException e) {
            e.printStackTrace();
            fail("IOException should not have been thrown.");
        }

          // Read the output file and check its contents
    try (BufferedReader reader = new BufferedReader(new FileReader(writer.getOutputFile()))) {
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line);
        }

        // Define the expected JSON output with pretty print
        String expectedJson = JsonWriter.formatJson(output.toString());

        // Assert that the output matches the expected JSON
        assertThat(output.toString().trim(), is(equalTo(expectedJson.trim())));
    } catch (IOException e) {
        fail("Error reading output file: " + e.getMessage());
    }
    }

    @Test
    public void testGetSourceData() throws IOException {
        // Create dummy report data
        Map<String, Object> reportData = new HashMap<>();
        reportData.put("basePath", "/path/to/local/copy");
        reportData.put("urls", Arrays.asList("http://www.url1.com", "https://www.url2.com"));

        // Write the report
        try {
            writer.writeReport(reportData);
        } catch (IOException e) {
            e.printStackTrace();
            fail("IOException should not have been thrown.");
        }

        // Get the source data and verify its content
        Map<String, Object> sourceData = writer.getSourceData();
        assertNotNull(sourceData);
        assertEquals(reportData, sourceData);
    }
}