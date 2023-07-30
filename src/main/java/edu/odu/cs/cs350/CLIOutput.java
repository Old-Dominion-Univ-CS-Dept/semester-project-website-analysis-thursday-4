package edu.odu.cs.cs350;


 import java.io.File;
 import java.io.FilenameFilter;

 /* 
 * This CLIOutput class will print the names of created files
 * to the command line interface 1 per line.
 */


public class CLIOutput {

    /*
     * Mainly created to for test purposes.
     */
    public static void basicOut(){
        String directory = (" ");
        System.out.println(directory);
    }
    

    public static void out(String[] args){

    /*
     * String to hold the directory.
     */
        String directory;

     /*
     * Assigning directory the return for the  currentDirectory
     */
        directory = currentDirectory();

     /*
     * Assigning the value of getJson to a file[].
     */
        File[] fJSON = getJSON(directory);

     /*
     * Using FJSON to output the name to CLI and linebreak.
     */
        for(File file : fJSON) {
            System.out.println(file.getName() + System.lineSeparator());

        }

     /*
     *  Assigning the value of getTXT to a file[].
     */
        File[] fTXT = getTXT(directory);

    /*
     * Using FTXT to output the name to CLI and linebreak.
     */    
        for(File file : fTXT) {
            System.out.println(file.getName() + System.lineSeparator());
        }

     /*
     * Assigning the value of getXLSX to a file[] variable.
     */
        File[] fXLSX = getXLSX(directory);

     /*
     * Using FTXT to output the name to CLI and linebreak.
     */ 
        for(File file : fXLSX) {
            System.out.println(file.getName() + System.lineSeparator());
        }

    }

    /*
     * This is passed the directory variable and is used to search for 
     * any .json files and return them.
     */
    public static File[] getJSON(String Directory) {
        File dir = new File(Directory);

     /*
     * This is used to filter through directory for a specific file ending with.json
     */     
        File[] fList = dir.listFiles(new FilenameFilter() {
            public boolean accept (File dir, String name) {
                return name.endsWith(".json");
            }
        });
        return fList;
    }

      /*
     * This is passed the directory variable and is used to search for 
     * any .txt files and return them.
     */
    public static File[] getTXT(String Directory) {
        File dir = new File(Directory);

    /*
     * This is used to filter through directory for a specific file ending with .txt
     */ 
        File[] fList = dir.listFiles(new FilenameFilter() {
            public boolean accept (File dir, String name) {
                return name.endsWith(".txt");
            }
        });
        return fList;
    }

      /*
     * This is passed the directory variable and is used to search for 
     * any .xlsx files and return them.
     */
    public static File[] getXLSX(String Directory) {
        File dir = new File(Directory);

     /*
     * This is used to filter through directory for a specific file ending with .xlsx
     * and will return the file name as a string.
     */
        File[] fList = dir.listFiles(new FilenameFilter() {
            public boolean accept (File dir, String name) {
                return name.endsWith(".xlsx");
            }
        });
        return fList;
    }

    /*
     * This is used to get the current directory and return it.
     */
    public static String currentDirectory(){
        String directory = System.getProperty("user.dir");
        return directory;
    }

    public static void CLIOutFromFileMaker(String fileName) throws Exception {

        System.out.println(fileName + "/n");
    }

}
