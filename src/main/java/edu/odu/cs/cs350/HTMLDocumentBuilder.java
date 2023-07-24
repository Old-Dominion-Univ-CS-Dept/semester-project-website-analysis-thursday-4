/**
 * This HTMLDocumentBuilder class will be responsible for 
 * extracting all tags from a single file containing HTML content. 
 * This is where out HTML parsing logic will exist. 
 */
package edu.odu.cs.cs350;

import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;
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
    private String theTag; 
    private String theAttribute; 
    private List<Element> images;
    private List<Element> scripts;
    private List<Element> stylesheets;
    private List<Element> anchors;
    
    
    /**
     * Default constructor for HTMLBuilder, may be implemented later.
     */    
    public HTMLDocumentBuilder()
    {
        this.theTag = null; 
        this.theAttribute = null; 
        this.images = new ArrayList<>(); 
    }
    
    
    
    /**
     * Extract all HTML image tags.
     * 
     * @param: HTML source code. 
     * 
     * @return: list of all image tags. 
     */    
    public List<Element> extractImages(BufferedReader htmlSource)
    {
        theTag = "img"; 
        theAttribute = "src"; 
        
        String htmlAsString = htmlSource.lines()
                .collect(Collectors.joining(System.lineSeparator())); 
        
        return this.extractImages(htmlAsString); 
    }
    
    
    /**
     * Extract all HTML image tags.
     * 
     * @param: HTML source code. 
     * 
     * @return: list of all image tags. 
     */  
    public List<Element> extractImages(String htmlSource)
    {
        theTag = "img"; 
        theAttribute = "src"; 
        
        Document doc = Jsoup.parse(htmlSource);
        Elements elements = doc.select(this.theTag);

        List<Element> elementList = new ArrayList<>();
        for (Element elm : elements) {
            elementList.add(elm);
            images.add(elm); 
        }

        return elementList;
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
        HTMLDocument htmlDocument = new HTMLDocument(scripts, stylesheets, images, anchors); 
        
        return htmlDocument; 
    }
    
    
}
