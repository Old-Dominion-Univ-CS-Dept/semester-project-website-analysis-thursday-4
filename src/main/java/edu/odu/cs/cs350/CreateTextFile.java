package edu.odu.cs.cs350;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateTextFile {
    
    public static void createtxtfile() throws IOException{
        /// Create a new Text file
    /// in format YYYYMMDD-HHMMSS- summary

    
    Date thisDate = new Date();

    ///Formating date to Year/Month/Day - Hours/Minutes/Seconds
    SimpleDateFormat dateForm = new SimpleDateFormat("YYYYMMdd-hhmmss-");
    System.out.println(dateForm.format(thisDate) + "summary");
    
    
    /// Create a file
    File file1 = new File(dateForm.format(thisDate) + "summary" + ".txt");

    ///create file writer class
    FileWriter fw = new FileWriter(file1);

    /// create a print writer class
    PrintWriter pw = new PrintWriter(fw);

    pw.write("test");
    pw.close();

    }
}
