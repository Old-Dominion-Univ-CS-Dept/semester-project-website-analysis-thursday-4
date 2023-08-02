/**
 * This file will test the functions of the HTMLDocumentBuilder class.
 */
package edu.odu.cs.cs350;

import org.junit.jupiter.api.TestMethodOrder;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.hamcrest.core.IsNull;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
/**
 * @author bonham36
 *
 */
public class TestHTMLDocumentBuilder 
{
    List<Resource> testAnchors = new ArrayList<>(); 
    List<Resource> testImages = new ArrayList<>(); 
    List<Resource> testScripts = new ArrayList<>(); 
    List<Resource> testStylesheets = new ArrayList<>(); 

    Path testPath; 
    List<URL> testURLList; 

    @BeforeEach
    public void setUp()
    {
        testURLList = new ArrayList<>(); 
    }
    
    @Test
    public void testDefaultConstructor()
    {
        HTMLDocumentBuilder testBuilder = new HTMLDocumentBuilder(); 

        assertThat(testBuilder, is(notNullValue())); 
    }

    @Test
    public void testWithContentFromBuffReader() 
        throws IOException, FileNotFoundException
    {
        BufferedReader testReader = new BufferedReader(new FileReader("src/test/resources/anchors.html"));
        HTMLDocumentBuilder testBuilder = new HTMLDocumentBuilder(); 
        testBuilder.withContentFrom(testReader); 

        assertThat(testBuilder, is(notNullValue())); 
        assertThat(testBuilder.toString(), containsString(testReader.toString())); 
        
    }

    @Test
    public void testWithContentFromFile()
    {
        fail("test needs to be implemented."); 
    }

    @Test
    public void testWithBaseURLs() throws MalformedURLException
    {
        testURLList = Arrays.asList(
            new URL("http://example1.com"),
            new URL("http://example2.com"),
            new URL("http://example3.com")
        );

        HTMLDocumentBuilder testBuilder = new HTMLDocumentBuilder(); 
        testBuilder.withBaseURLs(testURLList);

        assertThat(testBuilder, is(notNullValue())); 
        assertThat(testBuilder.toString(), containsString(testURLList.toString()));
    }

    @Test
    public void testwithWebsiteBaseDir()
    {
        testPath = Paths.get("src/test/resources/cs-landing-page"); 
        HTMLDocumentBuilder testBuilder = new HTMLDocumentBuilder(); 
        testBuilder.withWebsiteBaseDir(testPath); 

        assertThat(testBuilder, is(notNullValue(null))); 
        assertThat(testBuilder.toString(), containsString(testPath.toString())); 
    }

    @Test
    public void testExtractAnchors()
    {
        fail("test needs to be implemented."); 
    }
    
    @Test
    public void testExtractImages()
    {
        fail("test needs to be implemented."); 
    }

    @Test
    public void testExtractScripts()
    {
        fail("test needs to be implemented."); 
    }

    @Test
    public void testExtractStylesheets()
    {
        fail("test needs to be implemented."); 
    }

    @Test
    public void testExtractContent()
    {
        HTMLDocumentBuilder testBuilder = new HTMLDocumentBuilder(); 
        
        
    }
    
    @Test 
    public void testBuild()
    {
        HTMLDocumentBuilder testBuilder = new HTMLDocumentBuilder(); 
        HTMLDocument testDoc = new HTMLDocument(); 

        testDoc = testBuilder.build(); 

        assertThat(testDoc, is(notNullValue())); 

        assertThat(testDoc.getAnchors(), equalTo(testAnchors)); 
        assertThat(testDoc.getImages(), equalTo(testImages)); 
        assertThat(testDoc.getScrips(), equalTo(testScripts)); 
        assertThat(testDoc.getStylesheets(), equalTo(testStylesheets)); 
    }

    @Test
    public void testDetermineLocality()
    {
        fail("test needs to be implemented."); 
    }

    @Test
    public void testConvertURLToPath()
    {
        fail("test needs to be implemented."); 
    }

    @Test
    public void testDetermineFileSize()
    {
        fail("test needs to be implemented.");
    }

    @Test
    public void testIsURL()
    {
        fail("test needs to be implemented."); 
    }

    @Test
    public void testDetermineLocalityOfPath()
    {
        fail("test needs to be implemented."); 
    }

    @Test
    public void testDetermineLocalityOfURL()
    {
        fail("test needs to be implemented."); 
    }
}
