package edu.odu.cs.cs350; 
import com.cedarsoftware.util.io.JsonWriter; // ** need to use gradle
import java.io.FileWriter;

import java.io.File;

import java.util.*;

public class JSONReportWriter extends ReportWriter {
    private File outputFile;


    // JSONReportWriter class is responsible for generating a JSON report of a website analysis. 
    // It extends the ReportWriter class and overrides its write method (?). 
    // The class takes a Website object and a base file name as input, 
    // constructs a JSON object that includes various details about the website (such as the base path, 
    // URLs, pages, images, and files), and then writes this JSON object to a file. 

    
    
    // the JSON file that provides a detailed account of each page and resource on the site, 
    // including counts and listings of local and external images, scripts, stylesheets, and links. 
    // The JSON file shall also provide specific details for each image, archive file, video file, audio file, 
    // and non-categorized file, such as file size, path to resource, and number of pages on which an image is displayed


}
