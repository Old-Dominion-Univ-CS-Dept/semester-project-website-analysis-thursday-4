/**
 * This class represents a Website.  It contains  a base path, a collection of URLs, and a collection of HTML document objects.
 */
package edu.odu.cs.cs350;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
/**
 * @author bonham36
 *
 */


public class Website {
    private String basePath;
    private Collection<URL> urls;
    private Collection<HTMLDocument> documents;


    /**
     * Constructs a Website with a base path and URL collection.
     * @param basePath the base path.
     * @param urls the collection of URLs .
     */
    public Website(String basePath, Collection<URL> urls) {
        this.basePath = basePath;
        this.urls = new ArrayList<>(urls);
        this.documents = new ArrayList<>();  // Initializing the documents collection.
       
    }

    /**
     * Returns the base path of the website.
     * @return the base path of the website.
     */
    public String getBasePath() {
        return this.basePath;
    }

    /**
     * Returns the collection of URLs 
     * @return the collection of URLs 
     */
    public Collection<URL> getUrls() {
        return this.urls;
    }

    

    

}
