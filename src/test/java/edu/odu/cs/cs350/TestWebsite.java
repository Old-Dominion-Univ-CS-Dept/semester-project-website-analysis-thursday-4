package edu.odu.cs.cs350;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestWebsite {
    private Website website;
    private Collection<URL> urls;
    private Path basePath;

    @BeforeEach
    void setup() {
        basePath = Paths.get("src/test/resources/cs-landing-page");
        urls = new ArrayList<>();
        Collection<HTMLDocument> documents = new ArrayList<>();
        website = new Website(basePath, urls, documents);
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
