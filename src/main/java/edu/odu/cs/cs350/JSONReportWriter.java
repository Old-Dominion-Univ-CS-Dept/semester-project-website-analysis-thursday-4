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
     * Overrides the writeReport (not yet written) method from the ReportWriter class.
     * This method receives a Map containing the report data, converts it to a JSON string 
     * and writes it to the output file.
     *
     * @param reportData A map of report data to be written into the file.
     */

  
     @Override
     public void writeReport(Map<String, Object> reportData) {
          // Check if file exists, and if not, create it
          if (!outputFile.exists()) {
            outputFile.getParentFile().mkdirs(); // Create parent directories if not exist
            try {
                outputFile.createNewFile(); // Create the file itself
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

         try (FileWriter fileWriter = new FileWriter(outputFile)) {
             String jsonString = convertToJson(reportData);
             writeToFile(fileWriter, jsonString);
         } catch (IOException e) {
             e.printStackTrace();
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
        return JsonWriter.objectToJson(reportData, args);
    }

    /**
     * Writes a string to a file using a FileWriter.
     *
     * @param fileWriter The FileWriter to be used for writing the string.
     * @param jsonString The string to be written to the file.
     * @throws IOException If an I/O error occurs.
     */
    private void writeToFile(FileWriter fileWriter, String jsonString) throws IOException {
        fileWriter.write(jsonString);
    }
     
}




