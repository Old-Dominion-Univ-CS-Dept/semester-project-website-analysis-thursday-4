
package edu.odu.cs.cs350;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.assertEquals;





public class TestCreateTextFile {

    ///test file to see if it creates a file
    @Test
    public void TestTextFileGeneration(){
        Date thisDate = new Date();
        Date thisDate2 = new Date();

        //format the date
        SimpleDateFormat dateForm = new SimpleDateFormat("YYYYMMdd-hhmmss-");
        assertEquals(dateForm.format(thisDate),dateForm.format(thisDate2));
        
    }

    

}
