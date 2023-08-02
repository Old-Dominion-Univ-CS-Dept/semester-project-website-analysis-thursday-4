package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestStylesheet 
{
    @Test
    public void testDefaultConstructor()
    {
        Stylesheet testerStylesheet = new Stylesheet(); 
        assertThat(testerStylesheet.getTypeOfResource(), is(ResourceKind.STYLESHEET)); 
    }
}
