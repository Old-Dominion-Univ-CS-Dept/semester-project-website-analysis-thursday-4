/* 
 * This CLIOutput class will print the names of created files
 * to the command line interface 1 per line.
 */


package edu.odu.cs.cs350;

/*
 * @author Zelle001
 */

 import java.io.File;
 import java.io.FilenameFilter;


public class CLIOutput {

    public static void basicOut(){
        String directory = (" ");
        System.out.println(directory);
    }
    
    public static void out(String[] args) throws Exception {

        String directory;

        directory = currentDirectory();

        File[] fJSON = getJSON(directory);

        for(File file : fJSON) {
            System.out.println(file.getName() + System.lineSeparator());

        }

        File[] fTXT = getTXT(directory);

        for(File file : fTXT) {
            System.out.println(file.getName() + System.lineSeparator());
        }

        File[] fXLSX = getXLSX(directory);

        for(File file : fXLSX) {
            System.out.println(file.getName() + System.lineSeparator());
        }

    }

    public static File[] getJSON(String Directory) {
        File dir = new File(Directory);

        File[] fList = dir.listFiles(new FilenameFilter() {
            public boolean accept (File dir, String name) {
                return name.endsWith(".json");
            }
        });
        return fList;
    }

    public static File[] getTXT(String Directory) {
        File dir = new File(Directory);

        File[] fList = dir.listFiles(new FilenameFilter() {
            public boolean accept (File dir, String name) {
                return name.endsWith(".txt");
            }
        });
        return fList;
    }

    public static File[] getXLSX(String Directory) {
        File dir = new File(Directory);

        File[] fList = dir.listFiles(new FilenameFilter() {
            public boolean accept (File dir, String name) {
                return name.endsWith(".xlsx");
            }
        });
        return fList;
    }


    public static String currentDirectory(){
        String directory = System.getProperty("user.dir");
        return directory;
    }

}
