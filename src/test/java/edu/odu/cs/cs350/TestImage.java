package edu.odu.cs.cs350; 

// This will be my test file for testing ImageAnalysis.java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;



public class TestImage
{
    @Test
    public void testImage()
    {
        Image testerImage = new Image(); 
        assertThat(testerImage.typeOfResource, is(ResourceKind.IMAGE)); 
        
        
        
    }
}