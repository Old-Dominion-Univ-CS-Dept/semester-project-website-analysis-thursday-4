package edu.odu.cs.cs350;

/**
 * This class is used to create new Script objects during
 * extraction and analysis. 
 */
public class Script extends Resource
{
    /**
     * Default constructor sets typeOfResource to SCRIPT. 
     */
    public Script()
    {
        this.setTypeOfResource(ResourceKind.SCRIPT);
    }
}
