package edu.odu.cs.cs350;

//import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestLinkExtraction {
    

    //
    @Test
    public void TestIntraPage(){
        String link = "#one";
        String link3 = "Intra";

        Pattern patternIntraPage = Pattern.compile("#.*$");
        Matcher matcherIntraPage = patternIntraPage.matcher(link);

        if(matcherIntraPage.matches()){
       
        
            link = "Intra";
         }

         assertEquals(link,link3);

        
    }

    @Test
    public void TestIntraSite(){
        String link = "/twice";
        String link2 = "Intra-site";

         /// Establish a pattern to check if a link start with /
        Pattern patternIntraSite = Pattern.compile("^/.*$");
        Matcher matcherIntraSite = patternIntraSite.matcher(link);

         if(matcherIntraSite.matches()){
       
        
            link = "Intra-site";
         }

         assertEquals(link,link2);

    }

    @Test
    public void TestExternal(){
        String link = "http:";
        String link2 = "External";
        String Intrapage;
        String Intrasite;

         Pattern patternIntraPage = Pattern.compile("#.*$");
         Matcher matcherIntraPage = patternIntraPage.matcher(link);

          /// Establish a pattern to check if a link start with /
        Pattern patternIntraSite = Pattern.compile("^/.*$");
        Matcher matcherIntraSite = patternIntraSite.matcher(link);

        if(matcherIntraPage.matches()){
       
            Intrapage = "Intra-page";
         }
     
         else if (matcherIntraSite.matches()){
             Intrasite = "Intra-site";
         }
     
         else{
             link = "External";
         }

         assertEquals(link,link2);

    }
}
