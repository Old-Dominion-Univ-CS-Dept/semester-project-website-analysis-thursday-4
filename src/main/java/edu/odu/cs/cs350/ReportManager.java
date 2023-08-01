package edu.odu.cs.cs350;

/**
 * sets source data, determines the base filename, and 
 * handles writing reports.
 */
public class ReportManager
{
    private String baseFilename;
    private Website site;

    /**
     * Initializes a new instance of the ReportManager class.
     */
    public ReportManager()
    {
        this.baseFilename = null;
        this.site = null;
    }

    /**
     * Sets the source data.
     *
     * @param sourceData The Website object to set as the source data.
     */
    public void setSourceData(Website sourceData)
    {
        this.site = sourceData;
    }

    /**
     * Determines the base file name.
     *
     */
    public void determineBaseFileName()
    {
        this.baseFilename = "base_filename";
    }

    /**
     * Retrieves the base file name.
     *
     * @return The base file name as a string.
     */
    public String getBaseFilename() {
        return this.baseFilename;
    }

    /**
     * Retrieves the source data.
     *
     * @return The source data as a Website object.
     */
    public Website getSourceData() {
        return this.site;
    }
}
