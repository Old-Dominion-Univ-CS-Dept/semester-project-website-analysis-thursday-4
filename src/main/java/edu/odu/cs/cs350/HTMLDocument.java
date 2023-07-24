/**
 * 
 */
package edu.odu.cs.cs350;

import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * This class creates an object that contains the lists
 * of all the different extracted content: scrips, stylesheets, 
 * images, and anchors. 
 * 
 * @author bonham36
 *
 */
public class HTMLDocument 
{
    private List<Element> scrips; 
    private List<Element> stylesheets; 
    private List<Element> images; 
    private List<Element> anchors; 
    
    /**
     * @return: the list of scripts.
     */
    public List<Element> getScrips() {
        return scrips;
    }

    /**
     * @param: set scripts to list passed in. 
     */
    public void setScrips(List<Element> scrips) {
        this.scrips = scrips;
    }

    /**
     * @return: the list of stylesheets. 
     */
    public List<Element> getStylesheets() {
        return stylesheets;
    }

    /**
     * @param: set stylesheets to list passed in. 
     */
    public void setStylesheets(List<Element> stylesheets) {
        this.stylesheets = stylesheets;
    }

    /**
     * @return: the list of images. 
     */
    public List<Element> getImages() {
        return images;
    }

    /**
     * @param: set images to list passed in. 
     */
    public void setImages(List<Element> images) {
        this.images = images;
    }

    /**
     * @return: the list of anchors. 
     */
    public List<Element> getAnchors() {
        return anchors;
    }

    /**
     * @param: set anchors to list passed in. 
     */
    public void setAnchors(List<Element> anchors) {
        this.anchors = anchors;
    }

    /**
     * This default constructor that creates a new empty object. 
     */
    public HTMLDocument()
    {
        
    }
    
    /**
     * This constructor takes in a list for each type of extracted tag and creates
     * an HTMLDocument object that will be used by other functions.
     * 
     * @param: list of extracted script tags.
     * 
     * @param: list of extracted stylesheet tags.
     * 
     * @param: list of extracted image tags. 
     * 
     * @param: list of extracted anchor tags. 
     * 
     * @return: a new HTMLDocument object containing all lists
     * passed in as parameters. 
     */
    public HTMLDocument(List<Element> script, List<Element> stylesheet,
                        List<Element> image, List<Element> anchor)
    {
        this.scrips = script; 
        this.stylesheets = stylesheet; 
        this.images = image; 
        this.anchors = anchor; 
        
    }
}
