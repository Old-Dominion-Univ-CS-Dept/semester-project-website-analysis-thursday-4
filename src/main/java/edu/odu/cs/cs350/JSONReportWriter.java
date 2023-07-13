package edu.odu.cs.cs350;


import com.cedarsoftware.util.io.JsonWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

/**
 * The JSONReportWriter class extends the ReportWriter class and 
 * overrides its method to write reports in JSON format.
 * 
 * It uses the JsonWriter library to convert data into a JSON string
 *  and writes it to a file.
 */

public class JSONReportWriter extends ReportWriter {
    private File outputFile;

   /**
     * Default constructor initializing the outputFile with the 
     * filename "report.json".
     */
    public JSONReportWriter() {
        this.outputFile = new File("report.json");
    }
    /**
     * Getter method for the outputFile.
     *
     * @return File The output file object where the report will be written.
     */
    public File getOutputFile() {
        return outputFile;
    }

       /**
     * Overrides the writeReport method from the ReportWriter class.
     * This method receives a Map containing the report data, converts it to a JSON string 
     * and writes it to the output file.
     *
     * @param reportData A map of report data to be written into the file.
     */

  
     @Override
     public void writeReport(Map<String, Object> reportData) {
         try (FileWriter fileWriter = new FileWriter("report.json")) {
             Map<String, Object> args = new HashMap<>();
             args.put(JsonWriter.TYPE, false);
             String jsonString = JsonWriter.objectToJson(reportData, args);
             fileWriter.write(jsonString);
         } catch (IOException e) {
             // If an IOException is thrown, print the stack trace for debugging
             e.printStackTrace();
         }
     }
     
}




