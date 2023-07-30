package edu.odu.cs.cs350;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestResource 
{
    @Test
    public void testResourceConstructor()
    {
        Resource testResource = new Resource(); 
        assertThat(testResource.getTypeOfResource(), is(null)); 
        assertThat(testResource.getLocation(), is(null)); 
        assertThat(testResource.getSizeOfFile(), is(0)); 
        assertThat(testResource.getUrl(), is(null)); 
        assertThat(testResource.getPath(), is(null));
    }
}
