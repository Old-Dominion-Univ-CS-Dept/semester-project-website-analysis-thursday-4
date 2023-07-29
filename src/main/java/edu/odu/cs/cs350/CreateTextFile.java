package edu.odu.cs.cs350;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


/*
 * This Class will generate a text file and format the file to "YYYYMMDD-HHMMSS- "summary"".
 * Include one entry per line with the size and namem of each page encountered.
 */
public class CreateTextFile {
    
    /*
     * Create a new Text File
     * Format text file to "YYYYMMDD-HHMMSS- "summary""
     */
    public static void createtxtfile() throws Exception{


    // Generate
    Date thisDate = new Date();

    // Formating date to Year/Month/Day - Hours/Minutes/Seconds
    SimpleDateFormat dateForm = new SimpleDateFormat("YYYYMMdd-hhmmss-");
    
    // Print to date to console with format
    System.out.println(dateForm.format(thisDate) + "summary");
    
    
    /// Create a file
    File file1 = new File(dateForm.format(thisDate) + "summary" + ".txt");
    
    //Creating a string to send the filename to CLIoutput
    String fileName = file1.getName();

    //Send the filenamy to CLIOutput
    CLIOutput.CLIOutFromFileMaker(fileName);

    ///create file writer class
    FileWriter fw = new FileWriter(file1);

    /// create a print writer class
    PrintWriter pw = new PrintWriter(fw);

    pw.write("test");
    pw.close();

    }
}
