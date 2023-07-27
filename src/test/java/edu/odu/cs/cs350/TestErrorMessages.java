package edu.odu.cs.cs350;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/*
 * This tests functions in the error messages class.
 * 
 */

public class TestErrorMessages {
    
    @Test public void TestOverSize() {

        String check = "The website is over 1000 pages.";
        //Redirect output to capture message
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //Call Function
        errorMessages.overSize();

        //Get the message
        String message = outputStream.toString().trim();

        //Assert that messages match.
        assertEquals(check, message);

    }

    @Test public void TestUnderSize(){

        String check = "The website is less than 1 page.";
        //Redirect output to capture message
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //Call Function
        errorMessages.underSize();

        //Get the message
        String message = outputStream.toString().trim();

        //Assert that messages match.
        assertEquals(check, message);
    }

    @Test public void TestDirectoryUnreadable() {

        String check = "You do not have read permission to the directory.";
        //Redirect output to capture message
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //Call Function
        errorMessages.directoryUnreadable();

        //Get the message
        String message = outputStream.toString().trim();

        //Assert that messages match.
        assertEquals(check, message);

    }

    @Test public void TestBadPath() {

        String check = "The Directory does not exist.";

        //Redirect output to capture message
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //Call Function
        errorMessages.badPath();

        //Get the message
        String message = outputStream.toString().trim();

        //Assert that messages match.
        assertEquals(check, message);
    
    }

}
