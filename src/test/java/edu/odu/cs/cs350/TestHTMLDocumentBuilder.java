/**
 * This file will test the functions of the HTMLDocumentBuilder class.
 */
package edu.odu.cs.cs350;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.hamcrest.core.IsNull;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
/**
 * @author bonham36
 *
 */
public class TestHTMLDocumentBuilder 
{
    @Test
    public void testExtractImage()
    {
        String htmlSource = "<img src=\"img_girl.jpg\" alt=\"Girl in a jacket\" width=\"500\" height=\"600\">"; 
        
        HTMLDocumentBuilder tester = new HTMLDocumentBuilder(); 
        
        List<Element> images = tester.extractImages(htmlSource); 
        
        assertThat(images, is(notNullValue())); 
        assertThat(images.size(), equalTo(1)); 
    }
    
    @Test
    public void testExtractImages() throws IOException, FileNotFoundException
    {
        BufferedReader htmlSource = new BufferedReader(new FileReader("src/test/resources/images.html")); 
        
        HTMLDocumentBuilder tester = new HTMLDocumentBuilder(); 
        
        List<Element> images = tester.extractImages(htmlSource); 
        
        assertThat(images, is(notNullValue())); 
        assertThat(images.size(), equalTo(5)); 
    }
    
    @Test 
    public void testBuild()
    {
        fail("test needs to be implemented."); 
    }
}
