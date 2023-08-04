package edu.odu.cs.cs350;


import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @Override
    public void setBaseName(String baseName) {
        this.baseFilename = baseName;
        this.outputFile = new File("src/main/data/" + baseName + ".json");
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
     * Converts the Website data into a JSON string.
     *
     * @param website A Website object to be converted into a JSON string.
     * @return  The JSON string representation of the Website data.
     */
    private String convertToJson(Website website) {
        Map<String, Object> websiteMap = new HashMap<>();
    
        websiteMap.put("basePath", website.getBasePath().toString());

        List<String> urls = new ArrayList<>();
        for (URL url : website.getUrls()) {
            urls.add(url.toString());
        }
        websiteMap.put("urls", urls);

        List<Map<String, Object>> documentsData = new ArrayList<>();
        for (HTMLDocument document : website.getHtmlDocuments()) { 
            documentsData.add(documentToMap(document));
        }
        websiteMap.put("documents", documentsData);

        Map<String, Object> args = new HashMap<>();
        args.put(JsonWriter.PRETTY_PRINT, true);
        args.put(JsonWriter.TYPE, false);

        return JsonWriter.objectToJson(websiteMap, args);
    }

    /**
     * Converts a Resource object into a map.
     * 
     * @param resource The Resource to be converted.
     * @return A map containing the properties of the Resource.
     */
    
    private Map<String, Object> resourceToMap(Resource resource) {
        Map<String, Object> resourceMap = new HashMap<>();

        resourceMap.put("path", resource.getPath().toString());
        resourceMap.put("type", resource.getTypeOfResource().toString());
        resourceMap.put("classification", resource.getClass().toString());
        resourceMap.put("size", Long.toString(resource.getSizeOfFile()));

        resourceMap.put("typeOfResource", resource.getTypeOfResource());
        resourceMap.put("location", resource.getLocation());
        resourceMap.put("sizeOfFile", resource.getSizeOfFile());
        
        resourceMap.put("url", resource.getUrl().toString());

        return resourceMap;
    }

     /**
     * Converts a list of Resources into a list of maps.
     * 
     * @param document An HTMLDocument object.
     * @return A document map.
     */
    private Map<String, Object> documentToMap(HTMLDocument document) {
        Map<String, Object> documentMap = new HashMap<>();

        documentMap.put("scripts", resourcesToListOfMaps(document.getScrips()));
        documentMap.put("stylesheets", resourcesToListOfMaps(document.getStylesheets()));
        documentMap.put("images", resourcesToListOfMaps(document.getImages()));
        documentMap.put("anchors", resourcesToListOfMaps(document.getAnchors()));

        return documentMap;
    }


    /**
     * Converts a list of Resources into a list of maps.
     * 
     * @param resources The list of Resources to be converted.
     * @return A list of maps, where each map represents a Resource.
     */
    private List<Map<String, Object>> resourcesToListOfMaps(List<Resource> resources) {
        List<Map<String, Object>> listOfMaps = new ArrayList<>();

        for (Resource resource : resources) {
            listOfMaps.add(resourceToMap(resource));
        }

        return listOfMaps;
    }

     /**
     * Overrides the writeReport method from the ReportWriter class.
     * This method receives a Website object, converts it to a JSON string,
     * and writes it to the output file.
     *
     * @param website A Website object to be written into the file.
     * @throws IOException If an I/O error occurs.
     */

     @Override
     public void writeReport(Website website) throws IOException {
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