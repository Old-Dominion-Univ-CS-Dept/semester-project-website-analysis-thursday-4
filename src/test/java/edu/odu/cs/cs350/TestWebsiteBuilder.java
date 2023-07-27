package edu.odu.cs.cs350;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

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
        assertThat(builder.getUrl(), is(nullValue()));
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
        assertThat(builder.getUrl(), is(nullValue()));
        assertThat(builder.getUrl(), is(nullValue()));
    }   

  
}


