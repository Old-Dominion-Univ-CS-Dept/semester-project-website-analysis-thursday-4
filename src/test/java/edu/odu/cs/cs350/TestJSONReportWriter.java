package edu.odu.cs.cs350;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.fail;



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
    public void testWriteReport() {
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
            assertThat(line, containsString("\"basePath\":\"/path/to/local/copy\""));
        } catch (IOException e) {
            fail("Error reading output file: " + e.getMessage());
        }
    }
}