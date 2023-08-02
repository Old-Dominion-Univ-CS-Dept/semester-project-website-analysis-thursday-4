package edu.odu.cs.cs350;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the ReportManager class.
 */
public class TestReportManager {

    private ReportManager reportManager;
    private HTMLDocument htmlDocument;
    private String baseFilename;
    private Website site;

    /**
     * Setup operations to be performed before each test.
     */
    @BeforeEach
    public void setup() {
        reportManager = new ReportManager();
    }

    @Test
    public void testConstructor() {
        assertThat(reportManager.getSourceData(), is(equalTo(null)));
        assertThat(reportManager.getBaseFilename(), is(equalTo(null)));
    }

    /**
     * Tests the setSourceData method of the ReportManager class.
     */
    @Test
    public void testSetSourceData() {
        Path basePath = Paths.get("test");  
        Collection<URL> urls = new ArrayList<>();  
        Collection<HTMLDocument> documents = new ArrayList<>();  

        Website website = new Website(basePath, urls, documents);
        reportManager.setSourceData(website);
        assertThat(reportManager.getSourceData(), is(website));
    }

    /**
     * Tests the determineBaseFileName method of the ReportManager class.
     */
    @Test
    public void testDetermineBaseFileName() {
        reportManager.determineBaseFileName();
        String baseFilename = reportManager.getBaseFilename();
        Pattern timestampPattern = Pattern.compile("^\\d{4}_\\d{2}_\\d{2}_\\d{2}_\\d{2}_\\d{2}$");
        assertThat(timestampPattern.matcher(baseFilename).matches(), is(true));
    }

    @Test
    public void testWriteReportNames() {
        //just a basic test to verify no exceptions  are
        try (BufferedWriter nameWriter = new BufferedWriter(new FileWriter("src/main/data/testReportNames.txt"))) {
            reportManager.determineBaseFileName();
            reportManager.writeReportNames(nameWriter);
        } catch (IOException e) {
            assert(false);  
        }
    }

   
}

