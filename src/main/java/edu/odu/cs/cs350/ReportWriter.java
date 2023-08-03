package edu.odu.cs.cs350;

import java.io.IOException;

/**
 *
 * Abstract base class for report writers. It provides a contract
 * for writing reports with method writeReport which subclasses implement.
 * currently takes a Map containing report data, but will later take a Website object after further development.
 * 
 */
public abstract class ReportWriter {
    protected Website website;
    protected String baseFilename;


  
    /**
     * Sets the source data for this ReportWriter.
     *
     * @param site The Website object to set as the source data.
     */
        public void setSourceData(Website site) {
            this.website = site;
        }
    


    /**
     * Sets the base file name for this ReportWriter.
     *
     * @param baseFilename The base file name to set.
     */
    public void setBaseName(String baseName) {
        if(baseName == null) {
            throw new IllegalArgumentException("Base name cannot be null");
        }
        this.baseFilename = baseName;
    }
    /**
     * Abstract method to write a report to various format depending on the subclass. 
     * JSON,  XML, and text.    
     *
     * @param data The data for the report.
     * @throws IOException If an I/O error occurs.
     */
    public abstract void writeReport(Website website) throws IOException;

}