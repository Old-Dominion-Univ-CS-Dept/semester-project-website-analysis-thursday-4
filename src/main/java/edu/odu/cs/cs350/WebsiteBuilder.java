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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.stream.Stream;
import java.util.stream.Collectors;



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
 * Walks through the directory structure starting from the specified path. 
 * Extracts all subdirectories and files from the directory and its subdirectories.
 *
 * @param directoryPath the path to the directory to begin the walk from.
 * @return a list of all  files in the directory.
 * @throws IOException if an I/O error occurs when opening the directory.
 */
        
    public List<Path> walkDirectory(String directoryPath) throws IOException {
        Path pathToExamine = Paths.get(directoryPath);
        List<Path> directories = examineDirectory(pathToExamine);
        
        List<Path> allFiles = new ArrayList<>();
        for(Path directory : directories) {
            allFiles.addAll(directoryWalker(directory));
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
