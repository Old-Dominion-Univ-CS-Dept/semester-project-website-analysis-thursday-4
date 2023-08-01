package edu.odu.cs.cs350;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestWebsite {
    private Website website;
    private Collection<URL> urls;
    private Path basePath;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        urls = Arrays.asList(new URL("http://example1.com"), new URL("http://example2.com"));
        website = new Website(basePath, urls);
    }

    @Test
    public void testGetBasePath() {
        assertThat(website.getBasePath(), is(basePath));
    }

    @Test
    public void testGetUrls() {
        assertThat(website.getUrls(), containsInAnyOrder(urls.toArray(new URL[0])));
    }

   


    
}
