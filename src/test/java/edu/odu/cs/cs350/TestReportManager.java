package edu.odu.cs.cs350;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the ReportManager class.
 */
public class TestReportManager {

    private ReportManager reportManager;
    private HTMLDocument htmlDocument;

    /**
     * Setup operations to be performed before each test.
     */
    @BeforeEach
    public void setup() {
        reportManager = new ReportManager();
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
        assertThat(reportManager.getBaseFilename(), equalTo("base_filename"));
    }

   
}

