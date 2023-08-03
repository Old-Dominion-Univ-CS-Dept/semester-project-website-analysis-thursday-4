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
 */
public class JSONReportWriter extends ReportWriter {
    private static final String OUTPUT_FILE_NAME = "src/main/data/report.json";
    private File outputFile;

   /**
     * Default constructor initializing the outputFile with the 
     * filename "report.json".
     */
    public JSONReportWriter() {
        this.outputFile = new File(OUTPUT_FILE_NAME);

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
     * Overrides the writeReport method from the ReportWriter class.
     * This method receives a Website object, converts it to a JSON string,
     * and writes it to the output file.
     *
     * @param website A Website object to be written into the file.
     * @throws IOException If an I/O error occurs.
     */
    

        /**
     * Converts the Website data into a JSON string.
     *
     * @param website A Website object to be converted into a JSON string.
     * @return  The JSON string representation of the Website data.
     */
    private String convertToJson(Website website) {
        Map<String, Object> args = new HashMap<>();
        args.put(JsonWriter.TYPE, false);
        args.put(JsonWriter.PRETTY_PRINT, true); // Enable pretty print for readable JSON output
        return JsonWriter.objectToJson(website, args);
    }


     @Override
     public void writeReport(Website website) throws IOException {
         // Check if file exists, and if not, create it
         if (!outputFile.exists()) {
             outputFile.getParentFile().mkdirs(); // Create parent directories if not exist
             outputFile.createNewFile(); // Create the file itself
         }
 
         try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {
             String jsonString = convertToJson(website);
             writeToFile(bufferedWriter, jsonString);
         }
     }
    /**
     * Writes a string to a file using a BufferedWriter.
     *
     * @param writer The BufferedWriter to be used for writing the string.
     * @param jsonString The string to be written to the file.
     * @throws IOException If an I/O error occurs.
     */
    private void writeToFile(BufferedWriter writer, String jsonString) throws IOException {
        writer.write(jsonString);
        writer.write("\n");  
    }
}