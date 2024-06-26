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

import com.beust.jcommander.converters.PathConverter;

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
        //TODO: finish implementation. 
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
    public HTMLDocumentBuilder withWebsiteBaseDir(Path siteRoot) {
        this.baseDirectory = siteRoot;
        return this;
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
        
        for (String uriAsString : extractedStrings)
        {
            String baseSiteDirectory = this.baseDirectory.toString(); 
            Locality location = this.determineLocality(uriAsString, baseSiteDirectory, extractedStrings,
                                                        baseSiteDirectory,  uriAsString); 

            Resource anchor = new Anchor(); 

            anchor.setLocation(location); 

            if (location == Locality.EXTERNAL)
            {
                anchor.setUrl(new URL(uriAsString)); 
                anchor.setPath(null);
            }
            else
            {
                anchor.setUrl(null);

                String pathAsString = this.convertURLToPath(uriAsString, this.baseUrls);
                Path convertedPathAsString = Paths.get(pathAsString);  
                anchor.setPath(convertedPathAsString); 

                long fileSizeInKiB = this.determineFileSize(uriAsString); 
                anchor.setSizeOfFile(fileSizeInKiB); 
            }
            this.anchors.add(anchor); 
        }

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
            String baseSiteDirectory = this.baseDirectory.toString(); 
            Locality location = this.determineLocality(uriAsString, baseSiteDirectory, extractedStrings,
                                                        baseSiteDirectory,  uriAsString); 

            Resource image = new Image(); 

            image.setLocation(location); 

            if (location == Locality.EXTERNAL)
            {
                image.setUrl(new URL(uriAsString)); 
                image.setPath(null);
            }
            else
            {
                image.setUrl(null);

                String pathAsString = this.convertURLToPath(uriAsString, this.baseUrls);
                Path convertedPathAsString = Paths.get(pathAsString);  
                image.setPath(convertedPathAsString); 

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
        
        for (String uriAsString : extractedStrings)
        {
            String baseSiteDirectory = this.baseDirectory.toString(); 
            Locality location = this.determineLocality(uriAsString, baseSiteDirectory, extractedStrings,
                                                        baseSiteDirectory,  uriAsString); 

            Resource script = new Script(); 

            script.setLocation(location); 

            if (location == Locality.EXTERNAL)
            {
                script.setUrl(new URL(uriAsString)); 
                script.setPath(null);
            }
            else
            {
                script.setUrl(null);

                String pathAsString = this.convertURLToPath(uriAsString, this.baseUrls);
                Path convertedPathAsString = Paths.get(pathAsString);  
                script.setPath(convertedPathAsString); 

                long fileSizeInKiB = this.determineFileSize(uriAsString); 
                script.setSizeOfFile(fileSizeInKiB); 
            }
            this.scripts.add(script); 
        }

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
        
        for (String uriAsString : extractedStrings)
        {
            String baseSiteDirectory = this.baseDirectory.toString(); 
            Locality location = this.determineLocality(uriAsString, baseSiteDirectory, extractedStrings,
                                                        baseSiteDirectory,  uriAsString); 

            Resource stylesheet = new Stylesheet(); 

            stylesheet.setLocation(location); 

            if (location == Locality.EXTERNAL)
            {
                stylesheet.setUrl(new URL(uriAsString)); 
                stylesheet.setPath(null);
            }
            else
            {
                stylesheet.setUrl(null);

                String pathAsString = this.convertURLToPath(uriAsString, this.baseUrls);
                Path convertedPathAsString = Paths.get(pathAsString);  
                stylesheet.setPath(convertedPathAsString); 

                long fileSizeInKiB = this.determineFileSize(uriAsString); 
                stylesheet.setSizeOfFile(fileSizeInKiB); 
            }
            this.stylesheets.add(stylesheet); 
        }

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
     * This function determines locality with the help of three other functions. 
     * 
     * @param extractedURI the URI that was extracted from a file during analysis.
     * 
     * @param baseSiteDirectory the base site directory that the user supplied the program.
     * 
     * @param baseSiteURLs the base website URLs that the user supplied to the program. 
     * 
     * @param pathOfSourceDoc the path of the document which the URI was extracted. 
     * 
     * @param urlOfSourceDoc the URL of the document from which the URI was extracted.
     * 
     * @return the locality of the URI. 
     */
    public Locality determineLocality(
        String extractedURI,
        String baseSiteDirectory,
        List<String> baseSiteURLs,
        String pathOfSourceDoc,
        String urlOfSourceDoc
    ) 
    {
        if (isURL(extractedURI))
        {
            return determineLocalityOfURL(extractedURI, baseSiteURLs, urlOfSourceDoc); 
        }
        else
        {
            return determineLocalityOfPath(extractedURI, baseSiteDirectory, pathOfSourceDoc); 
        }
    }
    
    /**
     * Converts the URL to a path. 
     * 
     * @param uriAsString URI converted to a string. 
     * 
     * @param baseUrls URL that was passed in to HTMLDocumentBuilder. 
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
     * @param uriAsString URI converted to a string. 
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
     * @param possibleURL URI as a string that is being passed in. 
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
     * @param rawPath path as a string that is being examined. 
     * 
     * @param baseSiteDirectory base site directory of path. 
     * 
     * @param pathOfSourceDoc path of the source document on disk. 
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
        Path path = Paths.get(rawPath); 
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

    /**
     * This function determines and returns the locality of a URL that 
     * is passed in. 
     * 
     * @param rawURL URL as a string that is being passed in. 
     * 
     * @param baseSiteURLs list of base sites of the URL. 
     * 
     * @param urlOfSourceDoc URL of the source document on disk. 
     * 
     * @return: the locality of the passed in URL. 
     */
    public Locality determineLocalityOfURL(
        String rawURL,
        List<String> baseSiteURLs,
        String urlOfSourceDoc
    )
    {
        for (String baseSiteURL : baseSiteURLs)
        {
            if (rawURL.startsWith(baseSiteURL))
            {
                if (rawURL.startsWith(urlOfSourceDoc))
                {
                    return Locality.INTRAPAGE; 
                }
                return Locality.INTERNAL; 
            }
        }

        return Locality.EXTERNAL; 
    }

    @Override
    public String toString() {
        return "HTMLDocumentBuilder [images=" + images + ", scripts=" + scripts + ", stylesheets=" + stylesheets
                + ", anchors=" + anchors + ", baseUrls=" + baseUrls + ", baseDirectory=" + baseDirectory
                + ", readBuffer=" + readBuffer + "]";
    }

    

    
}