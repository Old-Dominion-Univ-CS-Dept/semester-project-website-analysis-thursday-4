/* 
 * This testCLIOutput class will test several parts of the CLIOutput class.
 */
package edu.odu.cs.cs350;

/*
 * @author zack931/zelle001
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;



public class TestCLIOutput {
    
    /*
     * String to get the user directory for testing.
     */

   String testDirectory = System.getProperty("user.dir");

    /*
     * Test for basic system output.
     */

    @Test
    public void testBasicOut() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        CLIOutput.basicOut();

        // Restore System.out
        System.setOut(System.out);

     /*
     * Strings to test for expected vs. actual output.
     */

        String expectedOutput = " ";
        String actualOutput = outputStream.toString().trim();
        assertEquals(expectedOutput, actualOutput);
    }

    /*
     * Test to run and check for the search and output of any .txt files 
     * within a certain directory
     */
     @Test public void testGetTXT(String Directory) {
        File[] testTXT = CLIOutput.getTXT(testDirectory);
        for(File file :testTXT) {
         assertTrue(file.getName().endsWith(".txt"));
        }
     }

     /*
     * Test to run and check for the search and output of any .json files 
     * within a certain directory
     */
      @Test public void testGetJSON(String Directory) {
        File[] testJSON = CLIOutput.getJSON(testDirectory);
        for(File file :testJSON) {
         assertTrue(file.getName().endsWith(".json"));
        }
     }

     /*
     * Test to run and check for the search and output of any .xlsx files 
     * within a certain directory
     */
      @Test public void testGetXLSX(String Directory) {
         File[] testXLSX = CLIOutput.getXLSX(testDirectory);
         for (File file : testXLSX) {
             assertTrue(file.getName().endsWith(".xlsx"));
         }
     }

     /*
     * Test to run and check that the directory returned is the correct one.
     */
     @Test public void testCurrentDirectory() {
      String expectedDirectory = System.getProperty("user.dir");
      String actualDirectory = CLIOutput.currentDirectory();
      assertEquals(expectedDirectory, actualDirectory);
     }

     @Test public void TestCLIOutFromFileMaker() throws Exception {

        //Set uf a variable to test against.
        String fileName = "testFileName";

        //Redirect output to capture message
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //Call Function
        CLIOutput.CLIOutFromFileMaker(fileName);

        String expected = fileName + "/n";
        String actual = outputStream.toString();

        //Assert that messages match.
        assertEquals(expected, actual);
    
    }

}
