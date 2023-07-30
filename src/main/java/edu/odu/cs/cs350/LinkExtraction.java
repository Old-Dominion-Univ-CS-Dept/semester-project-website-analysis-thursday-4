 package edu.odu.cs.cs350;

 import java.util.regex.Matcher;
 import java.util.regex.Pattern;

 public class LinkExtraction extends Anchor{
    

//         /*I want to extract links(anchor tags) from a page 
//          * Classify them as
//          * Intra-Page (link to another location on the page)
//          * Intra-site (link to another location on the same site)
//          * External (usually a url)
//          */

/*
 * Constructor for LinkExtraction Class
 */
public LinkExtraction(String htmlRepresentation) {
        super(htmlRepresentation);
        //TODO Auto-generated constructor stub
    }

//      }
public static String LinkTypeExtraction(String link){
    /// Establish a pattern to check if hte link starts with a hash #
    Pattern patternIntraPage = Pattern.compile("#.*$");
    Matcher matcherIntraPage = patternIntraPage.matcher(link);

    /// Establish a pattern to check if a link start with /
    Pattern patternIntraSite = Pattern.compile("^/.*$");
    /// match string with patter
    Matcher matcherIntraSite = patternIntraSite.matcher(link);

    ///Logic to set locality
    //
    if(matcherIntraPage.matches()){
       
       return "Intra_page";
    }

    else if (matcherIntraSite.matches()){
        return "Intra-site";
    }

    else{
        return "External";
    }

}


 }
