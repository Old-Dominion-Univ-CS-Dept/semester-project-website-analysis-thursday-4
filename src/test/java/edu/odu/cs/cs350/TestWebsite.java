package edu.odu.cs.cs350;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestWebsite {
    private Website website;
    private Collection<URL> urls;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        urls = Arrays.asList(new URL("http://example1.com"), new URL("http://example2.com"));
        website = new Website("/src/test/resources", urls);
    }

    @Test
    public void testGetBasePath() {
        assertThat(website.getBasePath(), is("/src/test/resources"));
    }

    @Test
    public void testGetUrls() {
        assertThat(website.getUrls(), containsInAnyOrder(urls.toArray(new URL[0])));
    }

   


    
}
