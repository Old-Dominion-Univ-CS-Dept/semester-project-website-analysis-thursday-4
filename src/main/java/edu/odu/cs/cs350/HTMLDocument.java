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
}
