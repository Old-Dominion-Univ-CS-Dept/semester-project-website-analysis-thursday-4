package edu.odu.cs.cs350;

import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestLinkExtraction {
    

    //
    @Test
    public void TestIntraSite(){
        String link = "#one";
        String link3 = "Intra";

        Pattern patternIntraPage = Pattern.compile("#.*$");
        Matcher matcherIntraPage = patternIntraPage.matcher(link);

        if(matcherIntraPage.matches()){
       
        
            link = "Intra";
         }

         assertEquals(link,link3);

        
    }
}
