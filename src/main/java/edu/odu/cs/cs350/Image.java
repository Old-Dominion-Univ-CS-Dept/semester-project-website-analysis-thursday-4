package edu.odu.cs.cs350; 

// The system must be able to extract the images (<img ...> tags) from a page. 
// Images should be classified as internal or external. 

// For each internal image, the file size shall be recorded.
// For each page, the URI of each image should be recorded. 
// For each image, the local pages on which it is referenced shall be recorded. 

public class Image extends Resource
{
    /* 
     * Default constructor sets typeOfResource to IMAGE. 
     */
    
    public Image()
    {
        typeOfResource = ResourceKind.IMAGE; 
        
    }
}