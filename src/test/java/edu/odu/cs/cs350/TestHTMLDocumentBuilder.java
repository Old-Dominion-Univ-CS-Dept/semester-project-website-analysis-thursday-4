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
    List<Resource> testAnchors;
    List<Resource> testImages;
    List<Resource> testScripts;
    List<Resource> testStylesheets;

    Path testPath; 
    List<URL> testURLList; 

    @BeforeEach
    public void setUp()
    {
        testAnchors = new ArrayList<>(); 
        testImages = new ArrayList<>(); 
        testScripts = new ArrayList<>(); 
        testStylesheets = new ArrayList<>();
        
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
        throws IOException, FileNotFoundException
    {
        HTMLDocumentBuilder testBuilder = new HTMLDocumentBuilder(); 
        BufferedReader testReader = new BufferedReader(new FileReader("src/test/resources/anchors.html"));
        Path testPath = Paths.get("src/test/resources"); 
        
        testBuilder.withContentFrom(testReader);
        testBuilder.withWebsiteBaseDir(testPath);
        testAnchors = testBuilder.extractAnchors(); 

        assertThat(testAnchors, is(notNullValue())); 
    }
    
    @Test
    public void testExtractImages() 
        throws IOException, FileNotFoundException
    {
        HTMLDocumentBuilder testBuilder = new HTMLDocumentBuilder(); 
        BufferedReader testReader = new BufferedReader(new FileReader("src/test/resources/images.html"));
        Path testPath = Paths.get("src/test/resources"); 
        
        testBuilder.withContentFrom(testReader);
        testBuilder.withWebsiteBaseDir(testPath);
        testImages = testBuilder.extractImages(); 

        assertThat(testImages, is(notNullValue())); 
    }

    @Test
    public void testExtractScripts()
        throws IOException, FileNotFoundException
    {
        HTMLDocumentBuilder testBuilder = new HTMLDocumentBuilder(); 
        BufferedReader testReader = new BufferedReader(new FileReader("src/test/resources/cs417-one-lecture/index.html"));
        Path testPath = Paths.get("src/test/resources/cs417-landing-page"); 
        
        testBuilder.withContentFrom(testReader);
        testBuilder.withWebsiteBaseDir(testPath);
        testScripts = testBuilder.extractScripts(); 

        assertThat(testScripts, is(notNullValue())); 
    }

    @Test
    public void testExtractStylesheets()
        throws IOException, FileNotFoundException
    {
        HTMLDocumentBuilder testBuilder = new HTMLDocumentBuilder(); 
        BufferedReader testReader = new BufferedReader(new FileReader("src/test/resources/cs417-one-lecture/index.html"));
        Path testPath = Paths.get("src/test/resources/cs417-landing-page"); 
        
        testBuilder.withContentFrom(testReader);
        testBuilder.withWebsiteBaseDir(testPath);
        testStylesheets = testBuilder.extractStylesheets(); 

        assertThat(testStylesheets, is(notNullValue())); 
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
        String possibleURL = new String("http://www.testsite.com/testing/for/class"); 
        HTMLDocumentBuilder testBuilder = new HTMLDocumentBuilder(); 
        assertThat(testBuilder.isURL(possibleURL), equalTo(true)); 

        possibleURL = "https://www.testsite.com/testing/for/class"; 
        assertThat(testBuilder.isURL(possibleURL), equalTo(true)); 

        possibleURL = "src/test/resources/image.html"; 
        assertThat(testBuilder.isURL(possibleURL), equalTo(false)); 

        possibleURL = "file:///Users/src/test/resources/testsite.html"; 
        assertThat(testBuilder.isURL(possibleURL), equalTo(true)); 

    }

    @Test
    public void testDetermineLocalityOfPath()
    {
        String testRawPath = new String("src/test/resource/image.html"); 
        String testBaseSiteDirectory = new String("src"); 
        String testPathOfSourceDoc = new String("src/test"); 
        HTMLDocumentBuilder testBuilder = new HTMLDocumentBuilder(); 

        assertThat(testBuilder.determineLocalityOfPath(testRawPath, testBaseSiteDirectory, testPathOfSourceDoc),
                    is(Locality.INTRAPAGE)); 

        testRawPath = "src/test/resource/image.html"; 
        testBaseSiteDirectory = "src"; 
        testPathOfSourceDoc = "main/src/test/resource"; 

        assertThat(testBuilder.determineLocalityOfPath(testRawPath, testBaseSiteDirectory, testPathOfSourceDoc),
                    is(Locality.INTERNAL)); 

        testRawPath = "src/test/resource/image.html"; 
        testBaseSiteDirectory = "main"; 
        testPathOfSourceDoc = "main/src/test/resource"; 

        assertThat(testBuilder.determineLocalityOfPath(testRawPath, testBaseSiteDirectory, testPathOfSourceDoc),
                    is(Locality.EXTERNAL)); 

    }

    @Test
    public void testDetermineLocalityOfURL()
    {
        String testRawURL = new String("http://www.test.com/result/internal"); 
        List<String> testBaseSiteUrls = new ArrayList<>(Arrays.asList(
            new String("http://www.test.com/result"),
            new String("http://www.test.com/passed"),
            new String("http://www.test.com/failed")));
        
        String testURLOfSourceDoc = new String("http://www.test.com/results/internal/test.txt"); 
        HTMLDocumentBuilder testBuilder = new HTMLDocumentBuilder(); 

        assertThat(testBuilder.determineLocalityOfURL(testRawURL, testBaseSiteUrls, testURLOfSourceDoc), 
                    is(Locality.INTERNAL)); 

        testRawURL = new String("http://www.test.com/result/intrapage"); 
        testBaseSiteUrls = new ArrayList<>(Arrays.asList(
            new String("http://www.test.com/result"),
            new String("http://www.test.com/passed"),
            new String("http://www.test.com/failed")));

            testURLOfSourceDoc = new String("http://www.test.com/"); 

            assertThat(testBuilder.determineLocalityOfURL(testRawURL, testBaseSiteUrls, testURLOfSourceDoc), 
                    is(Locality.INTRAPAGE)); 

        testRawURL = new String("http://www.test.com/result/external"); 
        testBaseSiteUrls = new ArrayList<>(Arrays.asList(
            new String("http://www.null.com/result"),
            new String("http://www.null.com/passed"),
            new String("http://www.null.com/failed")));

            testURLOfSourceDoc = new String("http://www.null.com/"); 

            assertThat(testBuilder.determineLocalityOfURL(testRawURL, testBaseSiteUrls, testURLOfSourceDoc), 
                    is(Locality.EXTERNAL)); 
    }
}
