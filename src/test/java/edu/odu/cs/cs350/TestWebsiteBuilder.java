package edu.odu.cs.cs350;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/**
 * Tests for the WebsiteBuilder class.
 */
public class TestWebsiteBuilder {
    private WebsiteBuilder builder;

    @BeforeEach
    public void setup() {
        builder = new WebsiteBuilder();
    }


    /**
    * Tests the withPath method of WebsiteBuilder. 
    */
    @Test
    public void testWithPath() {
        Path testPath = Paths.get("src/test/resources");
        builder.withPath(testPath);
        assertThat(builder.getBasePath(), is(testPath));
    }

    /**
     * Tests the WebsiteBuilder constructor.
     * Checks the expected initial default values.
     */
    @Test
    public void testDefaultConstructor() {
       

        // Check that the builder's initial state is as expected
        assertThat(builder.getBasePath(), is(nullValue()));
        assertThat(builder.getUrls(), is(empty()));
    }

    /**
     * Tests the getBasePath() method.
     * Checks that the  basePath field is null.
     */
    @Test
    public void testGetBasePath() {
        assertThat(builder.getBasePath(), is(nullValue()));
        

    }

    /**
     * Tests the getUrl() method.
     * Checks that the url field is null.
     */
    @Test
    public void testGetUrl() {
        assertThat(builder.getUrls(), is(empty()));
    }   

    /**
     * Tests the walkDirectory() method.
     */
    @Test
    public void testWalkDirectory() {
        try {
            List<Path> files = builder.walkDirectory("src/test/resources/cs-landing-page");
           
             // There should be three files which are in 2 directories: index.html, robots.txt, and test-layout.css.
             assertThat(files.size(), is(3));
            
        } catch (IOException e) {
            
            fail("Exception walking directory: " + e.getMessage());
        }
}

    /**
     * Tests the mapUrlToLocalPath() method.
     * @throws MalformedURLException if the URL is malformed
     */
 
     @Test
     public void testMapUrlsToLocalPath() throws IOException, URISyntaxException {
         Path basePath = Paths.get("Directory");
 
         Collection<URL> urls = new ArrayList<>();
         Collection<Path> expectedPaths = new ArrayList<>();
 
         // Read the test data from the file
         URL testFileUrl = this.getClass().getResource("/testURLS.txt");
         Path testFilePath = Paths.get(testFileUrl.toURI());
 
         List<String> lines = Files.readAllLines(testFilePath);
         for (String line : lines) {
             String[] parts = line.split(" -> ");  // split the line into URL and local path
             urls.add(new URL(parts[0]));
             expectedPaths.add(Paths.get(parts[1]));
         }
 
         Collection<Path> actualPaths = builder.mapUrlsToLocalPath(urls, basePath);

 
         assertThat(actualPaths, containsInAnyOrder(expectedPaths.toArray()));
     }


     @Test
     public void testSetBasePath() {
         Path expectedPath = Paths.get("/example/path");
         builder.setBasePath(expectedPath);  
     
         assertThat(builder.getBasePath(), is(expectedPath));  
     }


        @Test
        public void pruneNonHTMLFiles() throws IOException {
            //creating a list of 3 html files and 2 non-html files
            List<Path> files = Arrays.asList(
                Paths.get("test1.html"),
                Paths.get("test2.html"),
                Paths.get("test3.htm"),
                Paths.get("test4.txt"),
                Paths.get("test5.pdf")
            );

            

            List<Path> prunedFiles = builder.pruneNonHTMLFiles(files);

            // The prunedFiles list should only contain the HTML files
            assertThat(prunedFiles.size(), is(3));
            //testing to see that the list has the correct files
            assertThat(prunedFiles, hasItems(Paths.get("test1.html"), Paths.get("test2.html"), Paths.get("test3.htm")));
        }
     
}




