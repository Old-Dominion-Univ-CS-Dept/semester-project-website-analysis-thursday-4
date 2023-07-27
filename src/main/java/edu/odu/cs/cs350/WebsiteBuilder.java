/**
 * The WebsiteBuilder class will be responsible for collecting all 
 * information needed to create a Website object:
 *      i. one local directory path
 *     ii. one or more URLs
 */
package edu.odu.cs.cs350;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;


/**
 * @author bonham36
 *
 */
public class WebsiteBuilder 
{
    
    private String basePath;
    private String url;

    /**
     * Constructs a new WebsiteBuilder.
    * Initializes the 'basePath' and 'url' fields to null.
     */
    public WebsiteBuilder() {
        this.basePath = null;
        this.url = null;
    }

      /**
     * Returns the base path of the website.
     *
     * @return the base path of the website
     */
    public String getBasePath() {
        return this.basePath;
    }

    /**
     * Returns the URL of the website.
     *
     * @return the URL of the website
     */
    public String getUrl() {
        return this.url;
    }
  
    
}
