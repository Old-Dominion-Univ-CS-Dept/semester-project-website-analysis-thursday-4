/**
 * This HTMLDocumentBuilder class will be responsible for 
 * extracting all tags from a single file containing HTML content. 
 * This is where out HTML parsing logic will exist. 
 */
package edu.odu.cs.cs350;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
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
    private List<Resource> images;
    private List<Resource> scripts;
    private List<Resource> stylesheets;
    private List<Resource> anchors;
    
    private List<URL> baseUrls; 
    private Path baseDirectory; 
    
    private BufferedReader readBuffer; 
    
    /**
     * Default constructor for HTMLBuilder, initializes all data members. 
     */    
    public HTMLDocumentBuilder()
    {
        this.images = new ArrayList<>(); 
        this.scripts = new ArrayList<>(); 
        this.stylesheets = new ArrayList<>(); 
        this.anchors = new ArrayList<>(); 

        this.baseUrls = new ArrayList<>(); 
        this.baseDirectory = null; 

        this.readBuffer = null; 
    }
    
    /**
     * This functions takes in and sets members based on 
     * what type of content is being passed in. 
     * 
     * @param: content from a BufferedReader source. 
     */
    public void withContentFrom(BufferedReader reader)
    {
        //TODO: to be implemented later. 
        this.readBuffer = reader; 
    }
    
    /**
     * This functions takes in and sets members based on 
     * what type of content is being passed in. 
     * 
     * @param: content from a file source. 
     */
    public void withContentFrom(File file)
    {
        //TODO: to be implemented later. 
    }
    
    /**
     * A function that passes in a piece of data needed for path 
     * normalization and resource classification. 
     * 
     * @param: a path. 
     */
    public void withBaseDirectory(Path siteRoot)
    {
        //TODO: to be implemented later. 
        this.baseDirectory = siteRoot; 
    }
    
    /**
     * A function that passes in a piece of data needed for path 
     * normalization and resource classification. 
     * 
     * @param: a path. 
     */
    public void withBaseURLs(Collection<URL> urls)
    {
        //TODO: to be implemented later. 
        this.baseUrls = (List<URL>) urls; 
    }
    
    /**
     * Extract all HTML anchor tags. 
     * 
     * @return: list of all anchor tags. 
     */
    public List<Resource> extractAnchors() 
            throws IOException, FileNotFoundException
    {
        //TODO: finish implementation. 
        SimpleHTMLParser parser = new SimpleHTMLParser("a", "href"); 
        List<String> extractedStrings = parser.extractAllURIs(this.readBuffer); 
        
        return this.anchors; 
    }
    
    /**
     * Extract all HTML image tags.
     * 
     * @return: list of all image tags. 
     */  
    public List<Resource> extractImages() 
            throws IOException, FileNotFoundException
    {
        //TODO: finish implementation. 
        SimpleHTMLParser parser = new SimpleHTMLParser("img", "src"); 
        List<String> extractedStrings = parser.extractAllURIs(this.readBuffer); 

        for (String uriAsString : extractedStrings)
        {
            Locality location = this.determineLocality(uriAsString, this.baseUrls); 

            Resource image = new Image(); 

            image.setLocation(location); 

            if (location == Locality.EXTERNAL)
            {
                //image.setURL(); 
                image.setPath(null);
            }
            else
            {
                image.setUrl(null);

                String pathAsString = this.convertURLToPath(uriAsString, this.baseUrls); 
                //image.setPath();

                long fileSizeInKiB = this.determineFileSize(uriAsString); 
                image.setSizeOfFile(fileSizeInKiB); 
            }
            this.images.add(image); 
        }

        return this.images; 
    }
    
    /**
     * Extract all HTML script tags. 
     * 
     * @return: list of all script tags. 
     */
    public List<Resource> extractScripts() 
            throws IOException, FileNotFoundException
    {
      //TODO: finish implementation. 
        SimpleHTMLParser parser = new SimpleHTMLParser("script", "src"); 
        List<String> extractedStrings = parser.extractAllURIs(this.readBuffer); 
        
        return this.scripts; 
    }
    
    /**
     * Extract all HTML stylesheet tags. 
     * 
     * @return: list of all stylesheet tags. 
     */
    public List<Resource> extractStylesheets() 
            throws IOException, FileNotFoundException
    {
      //TODO: finish implementation. 
        SimpleHTMLParser parser = new SimpleHTMLParser("link", "href"); 
        List<String> extractedStrings = parser.extractAllURIs(this.readBuffer); 
        
        return this.stylesheets; 
    }

    /**
     * This function calls all four extraction functions one after the other. 
     */
    public void extractContent() 
        throws IOException, FileNotFoundException
    {
        this.extractAnchors(); 
        this.extractImages(); 
        this.extractScripts(); 
        this.extractStylesheets(); 
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
        HTMLDocument htmlDocument = new HTMLDocument(); 
        
        htmlDocument.setAnchors(anchors);
        htmlDocument.setImages(images);
        htmlDocument.setScrips(scripts);
        htmlDocument.setStylesheets(stylesheets);

        return htmlDocument; 
    }

    /**
     * Determines the location of the resource that is being extracted. 
     * 
     * @param uriAsString: URI that is being looped through, currently a string. 
     * 
     * @param baseUrls: URL that was passed in to HTMLDocumentBuilder. 
     * 
     * @return: location of this extracted content. 
     */
    public Locality determineLocality(String uriAsString, List<URL> baseUrls) 
    {
        //TODO: needs to be implemented. 
        return null;
    }
    
    /**
     * Converts the URL to a path. 
     * 
     * @param uriAsString: URI converted to a string. 
     * 
     * @param baseUrls: URL that was passed in to HTMLDocumentBuilder. 
     * 
     * @return: path from URL. 
     */
    public String convertURLToPath(String uriAsString, List<URL> baseUrls) 
    {
        //TODO: needs to be implemented. 
        return null;
    }

    /**
     * Determines the file size of the URI.
     * 
     * @param uriAsString: URI converted to a string. 
     * 
     * @return: file size of the URI. 
     */
    public long determineFileSize(String uriAsString) 
    {
        //TODO: needs to be implemented. 
        return 0;
    }

    /**
     * Function to determine if URI that is passed in is a URL. 
     * 
     * @param possibleURL: URI as a string that is being passed in. 
     * 
     * @return: True if URL, false if not a URL. 
     */
    public boolean isURL(String possibleURL)
    {
        return possibleURL.startsWith("http://") 
            || possibleURL.startsWith("https://")
            || possibleURL.contains(":"); 
    }

    /**
     * This function determines and returns the locality of a path that
     * is passed in. 
     * 
     * @param rawPath: path as a string that is being examined. 
     * 
     * @param baseSiteDirectory: base site directory of path. 
     * 
     * @param pathOfSourceDoc: path of the source document on disk. 
     * 
     * @return: the locality of the passed in path. 
     */
    public Locality determineLocalityOfPath(
        String rawPath,
        String baseSiteDirectory, 
        String pathOfSourceDoc
    )
    {
        //TODO: finish implementation. 
        Path path = Paths.get(rawPath, null); 
        path.normalize(); 

        String absolutePath = path.toString(); 

        if (absolutePath.startsWith(baseSiteDirectory))
        {
            if (rawPath.startsWith(pathOfSourceDoc))
            {
                return Locality.INTRAPAGE; 
            }
            return Locality.INTERNAL; 
        }

        return Locality.EXTERNAL; 

    }

    
}