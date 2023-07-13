package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestAnchor {

    @Test
    void testConstructor() {
        String htmlRepresentation = "<a href=\"https://example.com\">Example</a>";
        Anchor anchor = new Anchor(htmlRepresentation);

        assertEquals("https://example.com", anchor.getHref());
        assertEquals("Example", anchor.getText());
        assertEquals(ResourceKind.ANCHOR, anchor.getTypeOfResource());
        // TODO: Add assertion for linkType 
    }

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

    @Test
    void testIntraPageLink() {
        String htmlRepresentation = "<a href=\"#section1\">Section 1</a>";
        Anchor anchor = new Anchor(htmlRepresentation);

        assertEquals("#section1", anchor.getHref());
        assertEquals("Section 1", anchor.getText());
        // TODO: Add assertion for linkType
    }

    @Test
    void testIntraSiteLink() {
        String htmlRepresentation = "<a href=\"/page2\">Page 2</a>";
        Anchor anchor = new Anchor(htmlRepresentation);

        assertEquals("/page2", anchor.getHref());
        assertEquals("Page 2", anchor.getText());
        // TODO: Add assertion for linkType
    }

    @Test
    void testExternalLink() {
        String htmlRepresentation = "<a href=\"https://external.com\">External</a>";
        Anchor anchor = new Anchor(htmlRepresentation);

        assertEquals("https://external.com", anchor.getHref());
        assertEquals("External", anchor.getText());
        // TODO: Add assertion for linkType
    }

    @Test
    public void testGetTypeOfResource() {
        String htmlRepresentation = "<a href=\"https://example.com\">Example</a>";
        Anchor anchor = new Anchor(htmlRepresentation);

        assertEquals(ResourceKind.ANCHOR, anchor.getTypeOfResource());
    }
}
