package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestScript 
{
    @Test
    public void testDefaultConstructor()
    {
        Script testScript = new Script(); 
        assertThat(testScript.getTypeOfResource(), is(ResourceKind.SCRIPT)); 
    }
}
