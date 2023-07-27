package edu.odu.cs.cs350;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.io.BufferedReader;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;

/**
 * This class is responsible for parsing the HTML to extract tag
 * information. It takes an HTML tag and attribute, extracts all
 * tags, then all URLs from the specified attribute. 
 * 
 * @author bonham36
 *
 */
public class SimpleHTMLParser 
{
    private String theTag; 
    private String theAttribute; 
    
    /**
     * A default SimpleHTMLParser can not be created. 
     */
    private SimpleHTMLParser()
    {
        
    }
    
    /**
     * Constructor that takes in parameters to set
     * theTag and theAttribute data members. 
     * 
     * @param tag: String to set the tag that is being parsed. 
     * 
     * @param attribute: String to set the attribute that is being parsed. 
     */
    public SimpleHTMLParser(String tag, String attribute)
    {
        this.theTag = tag; 
        this.theAttribute = attribute; 
    }
    
    /**
     * This function extracts all HTML tags. A BufferedReader
     * is taken in and converted to a string, then a function 
     * call to extractAllTags that takes in a String is made to 
     * do the actual parsing. 
     * 
     * @param: HTML source code from BufferedReader. 
     * 
     * @return: list of all HTML tags. 
     */
    public List<Element> extractAllTags(BufferedReader htmlSource)
    {
        String htmlAsString = htmlSource.lines()
                .collect(Collectors.joining(System.lineSeparator())); 
        
        return this.extractAllTags(htmlAsString); 
    }
    
    /**
     * This function extracts all HTML tags. A String
     * is taken in and used for extraction. 
     * 
     * @param: HTML source code from String. 
     * 
     * @return: list of all HTML tags. 
     */
    public List<Element> extractAllTags(String htmlSource)
    {
        Document doc = Jsoup.parse(htmlSource); 
        Elements elements = doc.select(this.theTag); 
        
        List<Element> elementList = new ArrayList<>(); 
        for (Element elm : elements)
        {
            elementList.add(elm); 
        }
        
        return elementList; 
    }
    
    /**
     * Extract all URIs from HTML tags with the required attribute.
     *
     * @param: HTML source code
     *
     * @return: list of all HTML tags
     */
    public List<String> extractAllURIs(BufferedReader htmlSource)
    {
        String htmlAsString = htmlSource.lines()
                .collect(Collectors.joining(System.lineSeparator()));

        return this.extractAllURIs(htmlAsString);
    }

    /**
     * Extract all URIs from HTML tags with the required attribute.
     *
     * @param: HTML source code
     *
     * @return: list of all HTML tags
     */
    public List<String> extractAllURIs(String htmlSource)
    {
        Document doc = Jsoup.parse(htmlSource);
        Elements elements = doc.select(this.getJSoupSelector());

        List<String> elementList = new ArrayList<>();
        for (Element elm : elements) {
            elementList.add(elm.attr(this.theAttribute));
        }

        return elementList;
    }

    /**
     * Combine the specified tag and attribute for use in JSoup selector
     * syntax.
     *
     * @return: Jsoup style selector
     */
    public String getJSoupSelector()
    {
        return String.format("%s[%s]", this.theTag, this.theAttribute);
    }
    
    
}
