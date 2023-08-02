package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestResource 
{
    long ZERO_LONG = 0; 

    @Test
    public void testResourceConstructor()
    {
        Resource testResource = new Resource(); 
        assertThat(testResource.getTypeOfResource(), equalTo(null)); 
        assertThat(testResource.getLocation(), equalTo(null)); 
        assertThat(testResource.getSizeOfFile(), equalTo(ZERO_LONG)); 
        assertThat(testResource.getUrl(), equalTo(null)); 
        assertThat(testResource.getPath(), equalTo(null));
    }

    @Test
    public void testSetTypeOfResource()
    {
        Resource testResource = new Resource(); 
        testResource.setTypeOfResource(ResourceKind.IMAGE);

        assertThat(testResource.getTypeOfResource(), equalTo(ResourceKind.IMAGE)); 
        assertThat(testResource.getLocation(), equalTo(null)); 
        assertThat(testResource.getPath(), equalTo(null));
        assertThat(testResource.getUrl(), equalTo(null)); 
        assertThat(testResource.getSizeOfFile(), equalTo(ZERO_LONG));  
    }

    @Test
    public void testSetLocation()
    {
        Resource testResource = new Resource(); 
        testResource.setLocation(Locality.EXTERNAL);

        assertThat(testResource.getTypeOfResource(), equalTo(null)); 
        assertThat(testResource.getLocation(), equalTo(Locality.EXTERNAL)); 
        assertThat(testResource.getPath(), equalTo(null));
        assertThat(testResource.getUrl(), equalTo(null)); 
        assertThat(testResource.getSizeOfFile(), equalTo(ZERO_LONG));  
    }

    @Test
    public void testSetFileSize()
    {
        long TEST_SIZE = 256;
        Resource testResource = new Resource(); 
        testResource.setSizeOfFile(TEST_SIZE);

        assertThat(testResource.getTypeOfResource(), equalTo(null)); 
        assertThat(testResource.getLocation(), equalTo(null)); 
        assertThat(testResource.getPath(), equalTo(null));
        assertThat(testResource.getUrl(), equalTo(null)); 
        assertThat(testResource.getSizeOfFile(), equalTo(TEST_SIZE));  
    }

    @Test
    public void testSetPath()
    {
        Path testPath; 
        testPath = Paths.get("src/test/resources/cs-landing-page"); 
        Resource testResource = new Resource(); 
        testResource.setPath(testPath);

        assertThat(testResource.getTypeOfResource(), equalTo(null)); 
        assertThat(testResource.getLocation(), equalTo(null)); 
        assertThat(testResource.getPath(), equalTo(testPath));
        assertThat(testResource.getUrl(), equalTo(null)); 
        assertThat(testResource.getSizeOfFile(), equalTo(ZERO_LONG));  
    }

    @Test
    public void testSetURL() throws MalformedURLException
    {
        URL testURL = new URL("http://www.test.com"); 
        Resource testResource = new Resource(); 
        testResource.setUrl(testURL);

        assertThat(testResource.getTypeOfResource(), equalTo(null)); 
        assertThat(testResource.getLocation(), equalTo(null)); 
        assertThat(testResource.getPath(), equalTo(null));
        assertThat(testResource.getUrl(), equalTo(testURL)); 
        assertThat(testResource.getSizeOfFile(), equalTo(ZERO_LONG));  
    }
}
