package edu.odu.cs.cs350;

import java.net.URL;
import java.nio.file.Path;

/**
 * Resource class from outline that will be needed for what is extracted from 
 * by the HTMLDocumentBuilder class. 
 */
public class Resource
{
    private ResourceKind typeOfResource; 
    private Locality location; 
    private long sizeOfFile; 
    private Path path; 
    private URL url; 

    /**
     * Default constructor: initializes all members to either null or 0. 
     */
    public Resource()
    {
        this.typeOfResource = null; 
        this.location = null; 
        this.sizeOfFile = 0; 
        this.path = null; 
        this.url = null; 
    }
    
    /**
     * Retrieves the type of the resource object. 
     * 
     * @return: type of this resource object. 
     */
    public ResourceKind getTypeOfResource() {
        return typeOfResource;
    }

    /**
     * Sets the type of the resource object. 
     * 
     * @param typeOfResource type of resource to set. 
     */
    public void setTypeOfResource(ResourceKind typeOfResource) {
        this.typeOfResource = typeOfResource;
    }

    /**
     * Retrieves the locality of the resource:
     * INTERNAL, EXTERNAL, INTRAPAGE. 
     * 
     * @return: locality of this resource object. 
     */
    public Locality getLocation() {
        return location;
    }

    /**
     * Sets the location/locality of the resource. 
     * 
     * @param location location of resource to set. 
     */
    public void setLocation(Locality location) {
        this.location = location;
    }

    /**
     * Retrieves the size of the resource object. 
     * 
     * @return: size of this resource object. 
     */
    public long getSizeOfFile() {
        return sizeOfFile;
    }

    /**
     * Sets the size of the resource object. 
     * 
     * @param sizeOfFile size of resource to set. 
     */
    public void setSizeOfFile(long sizeOfFile) {
        this.sizeOfFile = sizeOfFile;
    }

    /**
     * Retrieves the path of the resource object. 
     * 
     * @return: path of this resource object. 
     */
    public Path getPath() {
        return path;
    }

    /**
     * Sets the path of the resource object. 
     * 
     * @param path path of resource to set. 
     */
    public void setPath(Path path) {
        this.path = path;
    }

    /**
     * Retrieves the URL of the resource object. 
     * 
     * @return: URL of this resource object. 
     */
    public URL getUrl() {
        return url;
    }

    /**
     * Sets the URL of the resource object. 
     * 
     * @param url URL of resource to set. 
     */
    public void setUrl(URL url) {
        this.url = url;
    }
    

}