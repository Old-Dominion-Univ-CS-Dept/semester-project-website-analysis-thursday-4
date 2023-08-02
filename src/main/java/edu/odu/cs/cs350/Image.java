package edu.odu.cs.cs350; 

/**
 * This class is used to create new Image objects during 
 * extraction and analysis. 
 */
public class Image extends Resource
{
    /* 
     * Default constructor sets typeOfResource to IMAGE. 
     */
    
    public Image()
    {
        this.setTypeOfResource(ResourceKind.IMAGE); 
        
    }
}