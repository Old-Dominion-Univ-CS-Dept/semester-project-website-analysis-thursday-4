/**
 * The WebsiteBuilder class will be responsible for collecting all 
 * information needed to create a Website object:
 *      i. one local directory path
 *     ii. one or more URLs
 */
package edu.odu.cs.cs350;

import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * @author bonham36
 *
 */
public class WebsiteBuilder 
{
    
    private Path basePath;
    private Collection<URL> urls;

    /**
     * Constructs a new WebsiteBuilder.
    * Initializes the 'basePath' and 'url' fields to null.
     */
    public WebsiteBuilder() {
        this.basePath = null;
        this.urls = new ArrayList<>();
    }

      /**
     * Returns the base path of the website.
     *
     * @return the base path of the website
     */
    public Path getBasePath() {
        return this.basePath;
    }

    /**
     * Returns the URLs of the website.
     *
     * @return the URLs of the website
     */
    public Collection<URL> getUrls() {
        return this.urls;
    }

    /**
     * Walks through the directory  and returns a list of Path objects
     * 
     * @param directoryPath the path to the directory to walk through
     * @return a list of Path objects for all the files in the directory 
     */
    public List<Path> walkDirectory(String directoryPath) {
        // Initial implementation to compile
        return Collections.emptyList();
    }

    /**
     * Maps a given URL to its corresponding local path.
     *
     * @param url the URL to map
     * @return the local path corresponding to the URL
     */
    public String mapUrlToLocalPath(URL url) {
        //  returning dummy path so it will compile 
        return "dummy/path";
    }
  
    
}
