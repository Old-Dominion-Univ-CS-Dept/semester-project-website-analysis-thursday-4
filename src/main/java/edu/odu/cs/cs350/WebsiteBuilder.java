
package edu.odu.cs.cs350;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The WebsiteBuilder class will be responsible for collecting all 
 * information needed to create a Website object:
 *      i. one local directory path
 *     ii. one or more URLs
 */
public class WebsiteBuilder 
{
    
    private Path basePath;
    private Collection<URL> urls;
    private Collection<HTMLDocument> documents;
   

    /**
     * Sets the local directory path for the website.
     *
     * @param Path the local directory.
     * @return this WebsiteBuilder instance.
     * @throws IllegalArgumentException if the path is not a directory.
     */
    public WebsiteBuilder withPath(Path basePath) {
        if (basePath == null || !Files.isDirectory(basePath)) {
            throw new IllegalArgumentException("Path must be a directory: " + basePath);
        }
        this.basePath = basePath;
        return this;
    }

    /**
     * Sets a single url to the website's url list
     *
     * @param url The URL to be stored.
     * @return This WebsiteBuilder instance.
     */
    public WebsiteBuilder withURL(URL url) {
        if (this.urls == null) {
            this.urls = new ArrayList<>();
        }
        this.urls.add(url);
        return this;
    }

    /**
     * accepts a collectioin URLs 
     * @param urls collection of URLs
     * @return This WebsiteBuilder instance.
     */
    public WebsiteBuilder withURLs(Collection<URL> urls) {
        this.urls = urls;
        return this;
    }

    





    /**
     * Constructs a new WebsiteBuilder.
    * Initializes the 'basePath' and 'url' fields to null.
     */
    public WebsiteBuilder() {
        this.basePath = null;
        this.urls = new ArrayList<>();
 
        
    }

    /**
     * Constructs a new WebsiteBuilder.
    * takes arguments for   'basePath', 'url', and 'documents' fields to null.
     */
    public WebsiteBuilder(Path basePath, Collection<URL> urls) {
        this.basePath = basePath;
        this.urls = urls;
    
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
 * Walks through the directory structure starting from the specified path. 
 * Extracts all subdirectories and files from the directory and its subdirectories.
 *
 * @return a list of all  files in the directory.
 * @throws IOException if an I/O error occurs when opening the directory.
 */
        
    public List<Path> walkDirectory() throws IOException {
        Path pathToExamine = basePath;
        List<Path> directories = examineDirectory(pathToExamine);
        
        
        List<Path> allFiles = new ArrayList<>();
        for(Path directory : directories) {
            allFiles.addAll(directoryWalker(directory));
          
        }

        if (allFiles.size()<1){
            errorMessages.underSize();
        }
        if (allFiles.size()>1000){
            errorMessages.overSize();
        }
        
        return allFiles;
    }

    /**
     * Examines the directory structure og the specified path and extracts all
     * subdirectories.
     *
     * @param pathToExamine the path to the directory to examine.
     * @return a list of Path objects for the subdirectories in the directory.
     * @throws IOException if an I/O error occurs when opening the directory.
     */
    private List<Path> examineDirectory(Path pathToExamine) throws IOException {
        List<Path> directoryList = new ArrayList<>();
        Files.walk(pathToExamine)
            .forEach((Path path) -> {
                if (Files.isDirectory(path)) {
                    directoryList.add(path);
                }
            });
        return directoryList;
    }

    /**
     * Walks through the  directory and extracts all files.
     *
     * @param directory the path to the directory to walk.
     * @return a list of paths for  all files in the directory.
     * @throws IOException if an I/O error occurs when opening the directory.
     */
    private List<Path> directoryWalker(Path directory) throws IOException {
        List<Path> fileList = new ArrayList<>();
        Files.walk(directory, 1)
            .forEach((Path path) -> {
                if (Files.isRegularFile(path)) {
                    fileList.add(path);
                }
            });
        return fileList;
    }

    /**
     * Takes a URLs and a base path, maps each URL to a local path. 
     * Removes the common URL prefix from each URL and uses the remaining  
     * URL with  prepended basePath. Initially writing the  transformed paths 
     * are written to a text file named "processed_paths.txt" for testing.
     * 
     * @param urls A collection of URLs to be mapped.
     * @param basePath The base path for the local files.
     * @return A collection of local file paths.
     */

     
     public Collection<Path> mapUrlsToLocalPath(Collection<URL> urls, Path basePath) throws IOException  {
        List<Path> localPaths = new ArrayList<>();
        String commonUrlPrefix = findCommonPrefix(urls);
    
        for (URL url : urls) {
            String urlPath = url.getPath();
        
            // Remove the common prefix from the URL path
            String localPath = urlPath.replaceFirst(commonUrlPrefix, "");  
        
            if (localPath.startsWith("/")) {
                localPath = localPath.substring(1);
            }
        
            Path transformedPath = basePath.resolve(localPath);
            localPaths.add(transformedPath);
        }
        
        return localPaths;
    }
    
    

    
    
    /**
     * Helper method to find the common prefix in a collection of URLs. Compares
     * the path of each URL to find the longest common prefix.
     * 
     * @param urls A collection of URLs 
     * @return The common prefix of the URL paths.
     */
    
    public String findCommonPrefix(Collection<URL> urls) {
        String commonPrefix = urls.stream()
                .map(URL::getPath)
                .reduce((s1, s2) -> {
                    int i = 0;
                    while (i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i)) {
                        i++;
                    }
                    return s1.substring(0, i);
                }).orElse("");
        return commonPrefix;
    }
    
    


    /**
     * Sets the base path of the files.
     *
     * @param basePath the base directory as a Path object.
     */
    public void setBasePath(Path basePath) {
        this.basePath = basePath;
    }
    
    /**
     * Sets a collection of URLs for the website.
     *
     * @param urls Collection of URLs to be stored.
     * @return This WebsiteBuilder instance.
     */
    public WebsiteBuilder setUrls(Collection<URL> urls) {
        this.urls = urls;
        return this;
    }
    
    
    
  


    /**
     * Removes any non-HTML files from the list of files. 
     * Checks the extension of each file and removes it 
     * from the list if it is not html or htm.
     *
     * @param files List of file paths that need to be pruned.
     * @return List of HTML file paths.
     */
    public List<Path> pruneNonHTMLFiles(List<Path> files) {
        List<Path> htmlFiles = new ArrayList<>();
        
        for (Path file : files) {
            if (file.toString().endsWith(".html") || file.toString().endsWith(".htm")) {
                htmlFiles.add(file);
            }
        }
    
        return htmlFiles;
    }
    

    /**
     * Builds a Website object with paths.
     *
     * @return a new Website object
     * @throws IOException if there's an error reading files 
     *  
    */
    public Website build() throws IOException {
        // Walk the directory and prune non-html files
        List<Path> files = walkDirectory();
        List<Path> prunedFiles = pruneNonHTMLFiles(files);

        Collection<HTMLDocument> parsedDocuments = new ArrayList<>();

        for (Path htmlFile : prunedFiles) {
            // Open the file for reading
            BufferedReader buffer = Files.newBufferedReader(htmlFile);

            // Parse the HTML document
            HTMLDocumentBuilder docBuilder = new HTMLDocumentBuilder();
            docBuilder.withContentFrom(buffer);
            docBuilder.withWebsiteBaseDir(this.basePath);  // needed for path normalization
            docBuilder.withBaseURLs(this.urls);  // needed for internal/external classification
            docBuilder.extractContent();  // exceptions can be thrown by this function

            HTMLDocument doc = docBuilder.build();
            parsedDocuments.add(doc);
        }

   
        Website site = new Website(this.basePath, this.urls, parsedDocuments);

        return site;
    }

}

