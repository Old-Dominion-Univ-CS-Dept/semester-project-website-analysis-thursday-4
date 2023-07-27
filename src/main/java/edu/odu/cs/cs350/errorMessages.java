package edu.odu.cs.cs350;

/*
 * This Class will be used to output error messages
 *  that you may see using this program
 */

public class errorMessages {

 /*
* This function will be called if the website is 
*over 1000 pages. Need URL/path and boundary code to implement.
*/
    public static void overSize() {

        System.out.println("The website is over 1000 pages.");
    }

/*
 * This function will be called if it is under 1 page.
 * Need URL/path and boundary code to implement.
 */
    public static void underSize(){
        System.out.println("The website is less than 1 page.");
    }
/*
 * This function will be called if you do not have proper
 * read permissions.Needs path code done to further implement.
 */
    public static void directoryUnreadable() {
        System.out.println("You do not have read permission to the directory.");
    }
/*
 * This function will be called if tha path is incorrect.
 * Needs path code done to further implement.
 */
    public static void badPath() {
        System.out.println("The Directory does not exist.");
    }
    
}
