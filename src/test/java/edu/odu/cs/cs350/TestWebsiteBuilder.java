package edu.odu.cs.cs350;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import static org.hamcrest.Matchers.equalTo;

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
    private Path basePath;
    private Collection<URL> urls;

    @BeforeEach
void setup() {
    builder = new WebsiteBuilder();
    basePath = Paths.get("src/test/resources/cs-landing-page");
    urls = new ArrayList<>();
    builder = new WebsiteBuilder(basePath, urls);
    
}


    /**
    * Tests the withPath method of WebsiteBuilder. 
    */
    @Test
public void testWithPath() {
    // Test with a valid path
    Path testPath = Paths.get("src/test/resources/cs-landing-page");
    builder.withPath(testPath);
    assertThat(builder.getBasePath(), is(equalTo(testPath)));

    // Test with a null path
    Exception nullPathException = assertThrows(IllegalArgumentException.class, () -> {
        builder.withPath(null);
    });
    assertThat(nullPathException.getMessage(), is(equalTo("Path must be a directory: null")));

    // Test with a non-directory path
    Path nonDirectoryPath = Paths.get("src/test/resources/cs-landing-page/index.html");
    Exception nonDirectoryPathException = assertThrows(IllegalArgumentException.class, () -> {
        builder.withPath(nonDirectoryPath);
    });
    assertThat(nonDirectoryPathException.getMessage(), is(equalTo("Path must be a directory: " + nonDirectoryPath.toString())));
}

    /**
    * Tests the withURL method of WebsiteBuilder. 
    */
    @Test
    public void testWithUrl() throws Exception {
        URL url = new URL("http://example.com");
        builder.withURL(url);
        assertThat(builder.getUrls(), containsInAnyOrder(url));
    }


    /**
    * Tests the withUrls method of WebsiteBuilder. 
    */
    @Test
    public void testWithUrls() throws Exception {
        List<URL> urls = new ArrayList<>(
                Arrays.asList(
                        new URL("http://example1.com"),
                        new URL("http://example2.com"),
                        new URL("http://example3.com")
                )
        );

        builder.withURLs(urls);

        assertThat(builder.getUrls(), containsInAnyOrder(urls.toArray()));
    }

    /**
     * Tests the WebsiteBuilder constructor.
     * Checks the expected initial default values.
     */
    @Test
    public void testDefaultConstructor() {
       

        // Check that the builder's initial state is as expected
        assertThat(builder.getBasePath(), is(basePath));
        assertThat(builder.getUrls(), is(urls));
    }

    /**
     * Tests the getBasePath() method.
     * Checks that the  basePath field is null.
     */
    @Test
    public void testGetBasePath() {
        assertThat(builder.getBasePath(), is(basePath));
        

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
            List<Path> files = builder.walkDirectory();
           
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
    public void testMapUrlsToLocalPath() {
        try {
            Path basePath = Paths.get("Directory");

            Collection<URL> urls = new ArrayList<>();
            Collection<Path> expectedPaths = new ArrayList<>();

            // Read the test data from the file
            URL testFileUrl = this.getClass().getResource("/testURLS.txt");
            if (testFileUrl == null) {
                fail("Test file not found");
            }
            
            Path testFilePath;
            try {
                testFilePath = Paths.get(testFileUrl.toURI());
            } catch (URISyntaxException e) {
                fail("URL to URI conversion failed: " + e.getMessage());
                return;
            }

            List<String> lines = Files.readAllLines(testFilePath);
            for (String line : lines) {
                String[] parts = line.split(" -> ");  // split the line into URL and local path
                urls.add(new URL(parts[0]));
                expectedPaths.add(Paths.get(parts[1]));
            }

            Collection<Path> actualPaths = builder.mapUrlsToLocalPath(urls, basePath);
            assertThat(actualPaths, containsInAnyOrder(expectedPaths.toArray()));
        } catch (IOException e) {
            fail("Exception occurred during the test: " + e.getMessage());
        }
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


        /**
         * Tests the build  method of WebsiteBuilder
         * @throws MalformedURLException
         */
        public void testBuild() {
            Collection<HTMLDocument> documents = new ArrayList<>();
            Website website = new Website(basePath, urls, documents);
        
            try {
                WebsiteBuilder builder = new WebsiteBuilder(basePath, urls);
                website = builder.build();
            } catch (IOException e) {
                e.printStackTrace();
            }
        
            Collection<HTMLDocument> actualDocuments = website.getHtmlDocuments();
            assertThat(website.getBasePath(), is(basePath));
            assertThat(website.getUrls(), containsInAnyOrder(urls.toArray(new URL[0])));
            assertThat(actualDocuments, is(notNullValue())); 
            assertThat(actualDocuments.size(), is(0)); 
        }
    }




