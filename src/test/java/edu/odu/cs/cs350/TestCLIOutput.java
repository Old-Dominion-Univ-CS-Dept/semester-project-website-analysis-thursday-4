package edu.odu.cs.cs350;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;



public class TestCLIOutput {
    
   String testDirectory = System.getProperty("user.dir");

    @Test
    public void testBasicOut() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        CLIOutput.basicOut();

        // Restore System.out
        System.setOut(System.out);

        String expectedOutput = " ";
        String actualOutput = outputStream.toString().trim();
        Assertions.assertEquals(expectedOutput, actualOutput);
    }


    //Test for .txt
     @Test public void testGetTXT(String Directory) {
        File[] testTXT = CLIOutput.getTXT(testDirectory);
        for(File file :testTXT) {
         Assertions.assertTrue(file.getName().endsWith(".txt"));
        }
     }

     //Test for JSON
      @Test public void testGetJSON(String Directory) {
        File[] testJSON = CLIOutput.getJSON(testDirectory);
        for(File file :testJSON) {
         Assertions.assertTrue(file.getName().endsWith(".json"));
        }
     }

     //Test for XLSX
      @Test public void testGetXLSX(String Directory) {
         File[] testXLSX = CLIOutput.getXLSX(testDirectory);
         for (File file : testXLSX) {
             Assertions.assertTrue(file.getName().endsWith(".xlsx"));
         }
     }

     //Test the directory.
     @Test public void testCurrentDirectory() {
      String expectedDirectory = System.getProperty("user.dir");
      String actualDirectory = CLIOutput.currentDirectory();
      Assertions.assertEquals(expectedDirectory, actualDirectory);
     }

}
