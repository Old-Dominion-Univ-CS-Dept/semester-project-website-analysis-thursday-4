/**
 * This class represents a Website.  It contains  a base path, a collection of URLs, and a collection of HTML document objects.
 */
package edu.odu.cs.cs350;

import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
/**
 * @author bonham36
 *
 */


public class Website {
    
    private Path basePath;
    private Collection<URL> urls;
    private Collection<HTMLDocument> documents;


    /**
     * Constructs a Website with a base path and URL collection.
     * @param string the base path.
     * @param urls the collection of URLs .
     */
    public Website(Path basePath, Collection<URL> urls, Collection<HTMLDocument> documents) {
        this.basePath = basePath;
        this.urls = new ArrayList<>(urls);
        this.documents = new ArrayList<>(documents);
    }

    /**
     * Returns the base path of the website.
     * @return the base path of the website.
     */
    public Path getBasePath() {
        return this.basePath;
    }

    /**
     * Returns the collection of URLs 
     * @return the collection of URLs 
     */
    public Collection<URL> getUrls() {
        return this.urls;
    }

    public Collection<HTMLDocument> getHtmlDocuments() {
        return this.documents;
    }

    /**
     * Adds an HTML document to the website.
     *
     * @param document The HTML document to add.
     */
    public void addPage(HTMLDocument document) {
        this.documents.add(document);
    }

   
    

    

}
