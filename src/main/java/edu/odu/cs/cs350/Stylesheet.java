package edu.odu.cs.cs350;

/**
 * This class is used to create new Stylesheet objects during
 * extraction and analysis. 
 */
public class Stylesheet extends Resource
{
    /**
     * Default constructor sets typeOfResource to SCRIPT. 
     */
    public Stylesheet()
    {
        this.setTypeOfResource(ResourceKind.STYLESHEET);
    }
}
