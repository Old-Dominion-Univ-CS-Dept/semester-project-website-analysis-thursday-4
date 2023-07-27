package edu.odu.cs.cs350;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;

import static org.hamcrest.Matchers.*;


import org.junit.jupiter.api.Test;



/**
 * Tests for the WebsiteBuilder class.
 */
public class TestWebsiteBuilder {

    /**
     * Tests the WebsiteBuilder constructor.
     * Checks the expected initial default values.
     */
    @Test
    public void testDefaultConstructor() {
        WebsiteBuilder builder = new WebsiteBuilder();

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
        WebsiteBuilder builder = new WebsiteBuilder();
        assertThat(builder.getBasePath(), is(nullValue()));
        

    }

    /**
     * Tests the getUrl() method.
     * Checks that the url field is null.
     */
    @Test
    public void testGetUrl() {
        WebsiteBuilder builder = new WebsiteBuilder();
        assertThat(builder.getUrls(), is(empty()));
    }   

    /**
     * Tests the walkDirectory() method.
     */
    @Test
    public void testWalkDirectory() {
        WebsiteBuilder builder = new WebsiteBuilder();
        //dummy directory for initial test
        List<Path> files = builder.walkDirectory("some/dummy/path");

        assertThat(files, is(empty()));
}

    /**
     * Tests the mapUrlToLocalPath() method.
     * @throws MalformedURLException if the URL is malformed
     */
    @Test
    public void testMapUrlToLocalPath() throws MalformedURLException {
        WebsiteBuilder builder = new WebsiteBuilder();
        URL url = new URL("https://www.example.com/dummy/path");
        String localPath = builder.mapUrlToLocalPath(url);

        //checking for dummy path for now for compilation
        assertThat(localPath, is("dummy/path"));
    }
    
}


