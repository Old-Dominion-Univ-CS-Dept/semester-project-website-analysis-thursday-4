
package edu.odu.cs.cs350;

import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Website represents a model of a website to be parsed or analyzed.
 * It contains a local directory path that serves as the base path for the website,
 * a collection of URLs, and a collection of parsed HTML documents.
 * 
 * A Website object is built from a local directory, and URLs are 
 * mapped to local files within that directory.
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
