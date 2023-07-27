/**
 * 
 */
package edu.odu.cs.cs350;


import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.hamcrest.core.IsNull;

import java.util.ArrayList;

/**
 * @author bonham36
 *
 */
public class TestHTMLDocument 
{
    @BeforeEach
    public void setUp()
    {
        // Set up later. 
    }
    
    @Test
    public void testDefaultConstructor()
    {
        HTMLDocument testDoc = new HTMLDocument(); 
        assertThat(testDoc, is(notNullValue())); 
    }
    
    @Test
    public void testNonDefaultConstructor()
    {
        List<Resource> scripts = new ArrayList<>(); 
        List<Resource> stylesheets = new ArrayList<>(); 
        List<Resource> images = new ArrayList<>();
        List<Resource> anchors = new ArrayList<>();
        
        HTMLDocument testDoc = new HTMLDocument(scripts, stylesheets, images, anchors); 
        assertThat(testDoc, is(notNullValue())); 
    }
}
