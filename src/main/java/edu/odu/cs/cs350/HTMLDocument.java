/**
 * 
 */
package edu.odu.cs.cs350;

import java.util.ArrayList;
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
    private List<Resource> scripts; 
    private List<Resource> stylesheets; 
    private List<Resource> images; 
    private List<Resource> anchors; 
    
    /**
     * This default constructor that creates a new empty object. 
     */
    public HTMLDocument()
    {
        this.scripts = new ArrayList<>(); 
        this.stylesheets = new ArrayList<>(); 
        this.images = new ArrayList<>(); 
        this.anchors = new ArrayList<>(); 
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
    public HTMLDocument(List<Resource> script, List<Resource> stylesheet,
                        List<Resource> image, List<Resource> anchor)
    {
        this.scripts = script; 
        this.stylesheets = stylesheet; 
        this.images = image; 
        this.anchors = anchor; 
        
    }
    
    /**
     * @return: the list of scripts.
     */
    public List<Resource> getScrips() {
        return scripts;
    }

    /**
     * @param: set scripts to list passed in. 
     */
    public void setScrips(List<Resource> scrips) {
        this.scripts = scrips;
    }

    /**
     * @return: the list of stylesheets. 
     */
    public List<Resource> getStylesheets() {
        return stylesheets;
    }

    /**
     * @param: set stylesheets to list passed in. 
     */
    public void setStylesheets(List<Resource> stylesheets) {
        this.stylesheets = stylesheets;
    }

    /**
     * @return: the list of images. 
     */
    public List<Resource> getImages() {
        return images;
    }

    /**
     * @param: set images to list passed in. 
     */
    public void setImages(List<Resource> images) {
        this.images = images;
    }

    /**
     * @return: the list of anchors. 
     */
    public List<Resource> getAnchors() {
        return anchors;
    }

    /**
     * @param: set anchors to list passed in. 
     */
    public void setAnchors(List<Resource> anchors) {
        this.anchors = anchors;
    }

    
    
}
