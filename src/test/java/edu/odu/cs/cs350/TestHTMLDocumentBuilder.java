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
    @BeforeEach
    public void setUp()
    {
        // Set up later. 
    }
    
    @Test
    public void testExtractImages()
    {
        fail("test needs to be implemented."); 
    }
    
    @Test 
    public void testBuild()
    {
        fail("test needs to be implemented."); 
    }
}
