package edu.odu.cs.cs350;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        this.baseFilename = null;
        // Datetime logic
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");  
        LocalDateTime now = LocalDateTime.now();  
        this.baseFilename = dtf.format(now) + "-summary";
      
        System.out.println("Base file name: " + this.baseFilename);
        
    }

    


    /**
     * Writes report names to the  BufferedWriter in the format "{baseFilename}.{extension}".
     * The extensions are "txt", "json", and "xlsx". Each report 
     * name is written on a new line.
     *
     * @param nameWriter The BufferedWriter object to write the report names to.
     * @throws IOException If an I/O error occurs.
     */
    public void writeReportNames(BufferedWriter nameWriter)
        throws IOException
    {
        String reportName = String.format("%s.txt", this.baseFilename);
        nameWriter.write(reportName + "\n");

        reportName = String.format("%s.json", this.baseFilename);
        nameWriter.write(reportName + "\n");

        reportName = String.format("%s.xlsx", this.baseFilename);
        nameWriter.write(reportName + "\n");

        nameWriter.flush();
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


    /**
     * Writes reports in all supported formats.
     * Creates report writer objects, sets the source data and base name, and writes each report. 
     *
     * @throws IOException If an I/O error occurs.
     */
    public void writeAll() throws IOException 
    {
        determineBaseFileName();

        ReportWriter writer = null;
    

        //TODO: finish text report implementation
        // writer = new TextReportWriter();
        // writer.setSourceData(this.site);
        // writer.setBaseName(this.baseFilename);
        // writer.writeReport();

        writer = new JSONReportWriter();
        writer.setSourceData(this.site);
        writer.setBaseName(this.baseFilename);
        writer.writeReport(this.site);

        // writer.writeReport();



        //TODO: finish excel report implentation
        // writer = new ExcelGenerator();
        // writer.setSourceData(this.site);
        // writer.setBaseName(this.baseFilename);
        // writer.writeReport();
        writer.writeReport(this.site);
    }
}
