/**
 * This HTMLDocumentBuilder class will be responsible for 
 * extracting all tags from a single file containing HTML content. 
 * This is where out HTML parsing logic will exist. 
 */
package edu.odu.cs.cs350;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * This class takes in different HTML tags and attributes
 * and extracts all tags of the given type. Currently, I am
 * focusing on extracting images only. Other tags will be 
 * supported as the implementation expands. 
 * 
 * @author bonham36
 *
 */
public class HTMLDocumentBuilder 
{
    private List<Resource> images;
    private List<Resource> scripts;
    private List<Resource> stylesheets;
    private List<Resource> anchors;
    
    private List<URL> baseUrls; 
    private Path baseDirectory; 
    
    private BufferedReader readBuffer; 
    
    
    /**
     * Default constructor for HTMLBuilder, initializes all data members. 
     */    
    public HTMLDocumentBuilder()
    {
        this.images = new ArrayList<>(); 
        this.scripts = new ArrayList<>(); 
        this.stylesheets = new ArrayList<>(); 
        this.anchors = new ArrayList<>(); 
    }
    
    
    /**
     * This functions takes in and sets members based on 
     * what type of content is being passed in. 
     * 
     * @param: content from a BufferedReader source. 
     */
    public void withContentFrom(BufferedReader reader)
    {
        //TODO: to be implemented later. 
    }
    
    /**
     * This functions takes in and sets members based on 
     * what type of content is being passed in. 
     * 
     * @param: content from a file source. 
     */
    public void withContentFrom(File file)
    {
        //TODO: to be implemented later. 
    }
    
    /**
     * A function that passes in a piece of data needed for path 
     * normalization and resource classification. 
     * 
     * @param: a path. 
     */
    public void withBaseDirectory(Path siteRoot)
    {
        //TODO: to be implemented later. 
    }
    
    /**
     * A function that passes in a piece of data needed for path 
     * normalization and resource classification. 
     * 
     * @param: a path. 
     */
    public void withBaseURLs(Collection<URL> urls)
    {
        //TODO: to be implemented later. 
    }
    
    /**
     * Extract all HTML anchor tags. 
     * 
     * @return: list of all anchor tags. 
     */
    public List<Resource> extractAnchors() 
            throws IOException, FileNotFoundException
    {
        //TODO: finish implementation. 
        SimpleHTMLParser parser = new SimpleHTMLParser("a", "href"); 
        List<String> extractedStrings = parser.extractAllURIs(this.readBuffer); 
        
        return this.anchors; 
    }
    
    
    /**
     * Extract all HTML image tags.
     * 
     * @return: list of all image tags. 
     */  
    public List<Resource> extractImages() 
            throws IOException, FileNotFoundException
    {
        //TODO: finish implementation. 
        SimpleHTMLParser parser = new SimpleHTMLParser("img", "src"); 
        List<String> extractedStrings = parser.extractAllURIs(this.readBuffer); 
        
        
        return this.images; 
    }
    
    /**
     * Extract all HTML script tags. 
     * 
     * @return: list of all script tags. 
     */
    public List<Resource> extractScripts() 
            throws IOException, FileNotFoundException
    {
      //TODO: finish implementation. 
        SimpleHTMLParser parser = new SimpleHTMLParser("script", "src"); 
        List<String> extractedStrings = parser.extractAllURIs(this.readBuffer); 
        
        return this.scripts; 
    }
    
    /**
     * Extract all HTML stylesheet tags. 
     * 
     * @return: list of all stylesheet tags. 
     */
    public List<Resource> extractStylesheets() 
            throws IOException, FileNotFoundException
    {
      //TODO: finish implementation. 
        SimpleHTMLParser parser = new SimpleHTMLParser("link", "href"); 
        List<String> extractedStrings = parser.extractAllURIs(this.readBuffer); 
        
        return this.stylesheets; 
    }
    
    /**
     * Builds an HTMLDocument object that contains the scripts, stylesheets, 
     * images, and anchors lists.
     * 
     * @return: a new HTMLDocument object that contains the lists of all 
     * extracted content. 
     */
    public HTMLDocument build()
    {
        return null; 
    }
    
    
}
