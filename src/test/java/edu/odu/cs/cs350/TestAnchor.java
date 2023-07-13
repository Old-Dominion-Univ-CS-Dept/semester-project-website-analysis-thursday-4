package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestAnchor {
    @Test
    public void testGetHref() {
        Anchor anchor = new Anchor("<a href=\"http://example.com\">Example</a>");
        assertEquals("http://example.com", anchor.getHref());
    }

    @Test
    public void testGetText() {
        Anchor anchor = new Anchor("<a href=\"http://example.com\">Example</a>");
        assertEquals("Example", anchor.getText());
    }
}
