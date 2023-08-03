package edu.odu.cs.cs350;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
        // Create dummy website
        Website website = createDummyWebsite();

        // Write the report
        try {
            writer.writeReport(website);
        } catch (IOException e) {
            e.printStackTrace();
            fail("IOException should not have been thrown.");
        }

        // Verify that the output file was written to
        assertThat(outputFile.exists(), is(true));
        }

    public Website createDummyWebsite() throws MalformedURLException {
        // Create dummy Resource instances
        Resource resource1 = new Resource();
        resource1.setTypeOfResource(ResourceKind.SCRIPT);
        resource1.setLocation(Locality.INTERNAL);
        resource1.setSizeOfFile(500L);
        resource1.setPath(Paths.get("src/test/resources/resource1.js"));
        resource1.setUrl(new URL("http://example1.com/resource1.js"));
    
        Resource resource2 = new Resource();
        resource2.setTypeOfResource(ResourceKind.IMAGE);
        resource2.setLocation(Locality.EXTERNAL);
        resource2.setSizeOfFile(1000L);
        resource2.setPath(Paths.get("src/test/resources/resource2.jpg"));
        resource2.setUrl(new URL("http://example2.com/resource2.jpg"));
    
        // Create dummy HTMLDocument instances
        HTMLDocument document1 = new HTMLDocument(
            Arrays.asList(resource1), // scripts
            new ArrayList<>(), // stylesheets
            Arrays.asList(resource2), // images
            new ArrayList<>() // anchors
        );
    
        HTMLDocument document2 = new HTMLDocument(
            new ArrayList<>(),
            Arrays.asList(resource1),
            new ArrayList<>(),
            Arrays.asList(resource2)
        );
    
        // Create dummy Website instance
        return new Website(
            Paths.get("src/test/resources"),
            Arrays.asList(new URL("http://example1.com"), new URL("http://example2.com")),
            Arrays.asList(document1, document2)
        );
    }
    

    
}