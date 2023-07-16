package edu.odu.cs.cs350;

import java.util.Map;
import java.io.IOException;

/**
 *
 * Abstract base class for report writers. It provides a contract
 * for writing reports with method writeReport which subclasses implement.
 * currently takes a Map containing report data, but will later take a Website object after further development.
 * 
 */
public abstract class ReportWriter {

    /**
     * Abstract method to write a report to various format depending on the subclass. 
     * JSON,  XML, and text.    
     *
     * @param data The data for the report.
     * @throws IOException If an I/O error occurs.
     */
    public abstract void writeReport(Map<String, Object> data) throws IOException;

}