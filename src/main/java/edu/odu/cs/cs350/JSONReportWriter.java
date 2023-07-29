package edu.odu.cs.cs350;


import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;

import com.cedarsoftware.util.io.JsonWriter;

/**
 * The JSONReportWriter class extends the ReportWriter class and 
 * overrides its method to write reports in JSON format.
 * 
 * It uses the JsonWriter library to convert data into a JSON string
 * and writes it to a file.
 * 
 * Currently this class takes a Map containing test report data,
 * After further development, this method will take a Website object as a parameter.
 */
public class JSONReportWriter extends ReportWriter {
    private static final String OUTPUT_FILE_NAME = "src/main/data/report.json";
    private Map<String, Object> sourceData;
    private File outputFile;

   /**
     * Default constructor initializing the outputFile with the 
     * filename "report.json".
     */
    public JSONReportWriter() {
        this.outputFile = new File(OUTPUT_FILE_NAME);

        ///Added to simplfy CLI output
        System.out.println(OUTPUT_FILE_NAME + "/n");
    }

    /**
     * Constructor allows specifying the output file.
     * 
     * @param outputFile The output file where the report will be written.
     */
    public JSONReportWriter(File outputFile) {
        this.outputFile = outputFile;
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
     * Overrides the writeReport (not yet written) method from the ReportWriter class.
     * This method receives a Map containing the report data, converts it to a JSON string 
     * and writes it to the output file.
     *
     * @param reportData A map of report data to be written into the file.
     */

    /**
     * Getter method for the source data.
     *
     * @return Map The source data of the report.
     */
    public Map<String, Object> getSourceData() {
        return sourceData;
    }

    /**
     * Writes a string to a file using a FileWriter.
     *
     * @param fileWriter The FileWriter to be used for writing the string.
     * @param jsonString The string to be written to the file.
     * @throws IOException If an I/O error occurs.
     */
     private void writeToFile(BufferedWriter writer, String jsonString) throws IOException {
        writer.write(jsonString);
     }

    /**
     * Overrides the writeReport method from the ReportWriter class.
     * This method receives a map containing the report data, converts it to a JSON string,
     * and writes it to the output file.
     *
     * @param reportData A map of report data to be written into the file.
     * @throws IOException If an I/O error occurs.
     */
     @Override
     public void writeReport(Map<String, Object> reportData) throws IOException {
        // Check if file exists, and if not, create it
        if (!outputFile.exists()) {
            outputFile.getParentFile().mkdirs(); // Create parent directories if not exist
            outputFile.createNewFile(); // Create the file itself
        }
    
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {
            String jsonString = convertToJson(reportData);
            writeToFile(bufferedWriter, jsonString);
            this.sourceData = reportData;
        }
    }

    /**
     * Converts the report data into a JSON string.
     *
     * @param reportData A map of report data to be converted into a JSON string.
     * @return  The JSON string representation of the report data.
     */
    private String convertToJson(Map<String, Object> reportData) {
        Map<String, Object> args = new HashMap<>();
        args.put(JsonWriter.TYPE, false);
        args.put(JsonWriter.PRETTY_PRINT, true); // Enable pretty print for readable JSON output
        return JsonWriter.objectToJson(reportData, args);
    }

  
     
}




