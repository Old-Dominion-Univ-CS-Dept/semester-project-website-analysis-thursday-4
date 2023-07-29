 package edu.odu.cs.cs350;

 import java.util.regex.Matcher;
 import java.util.regex.Pattern;

 public class LinkExtraction extends Anchor{
    

//     /*Constructior for the LinkExtraction Class
//      * 
//      */

//      public LinkExtraction()
//      {
//         location = Locality.EXTERNAL;

//         /*I want to extract links(anchor tags) from a page 
//          * Classify them as
//          * Intra-Page (link to another location on the page)
//          * Intra-site (link to another location on the same site)
//          * External (usually a url)
//          */

//         String urlchecker = 
//         Pattern urlPattern = Pattern.com

public LinkExtraction(String htmlRepresentation) {
        super(htmlRepresentation);
        //TODO Auto-generated constructor stub
    }

//      }
public static String LinkTypeExtraction(String link){
    /// Establish a pattern to check if hte link starts with a hash #
    Pattern patternIntraPage = Pattern.compile("#,*$");
    Matcher matcherIntraPage = matcherIntraPage.matcher(link);

    /// Establish a pattern to check if a link start with /
   // Pattern patternIntraSite = Pattern.compile("^/.*$");



}


 }
