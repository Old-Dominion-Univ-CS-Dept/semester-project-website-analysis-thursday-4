package edu.odu.cs.cs350;

import java.util.regex.*;

/**
 * This Anchor class extends the Resource class.
 * It extracts the href attribute and the text between the opening and closing tags
 * and classifies the link as intra-page, intra-site, or external.
 * 
 */

 public class Anchor extends Resource {
    private String htmlRepresentation;
    private String href;
    private String text;
    private LinkType linkType;

    /**
     * Enum for the type of link: intra-page, intra-site, or external.
     */
    public enum LinkType {
        INTRA_PAGE,
        INTRA_SITE,
        EXTERNAL
    }

    /**
     * Constructor for the Anchor class.
     * @param htmlRepresentation The HTML representation of the anchor tag.
     * @param currentUrl The URL of the current page.
     * @param siteUrl The base URL of the site.
     */
    public Anchor(String htmlRepresentation) {
        this.htmlRepresentation = htmlRepresentation;
        Pattern hrefPattern = Pattern.compile("href=\"(.*?)\"");
        Matcher hrefMatcher = hrefPattern.matcher(htmlRepresentation);
        if (hrefMatcher.find()) {
            this.href = hrefMatcher.group(1);
        }
        Pattern textPattern = Pattern.compile(">(.*?)<");
        Matcher textMatcher = textPattern.matcher(htmlRepresentation);
        if (textMatcher.find()) {
            this.text = textMatcher.group(1);
        }

         // Set the type of resource to ANCHOR
         typeOfResource = ResourceKind.ANCHOR;
        
            /**
             * TODO: Update this section once siteUrl is defined
             * If the href starts with "#", it's an intra-page link.
             * If the href starts with siteUrl, it's an intra-site link.
             * Otherwise, it's an external link.
             * 
             */
    }
       /**
     * Returns the HTML representation of the anchor tag.
     *
     * @return The HTML representation of the anchor tag.
     */
    public String getHtmlRepresentation() {
        return htmlRepresentation;
    }
    /**
     * Returns the href attribute of the anchor tag.
     *
     * @return The href attribute of the anchor tag.
     */
    public String getHref() {
        return href;
    }
    /**
     * Returns the text between the opening and closing tags of the anchor tag.
     *
     * @return The text between the opening and closing tags of the anchor tag.
     */
    public String getText() {
        return text;
    }
      /**
     * Returns the type of link: intra-page, intra-site, or external.
     *
     * @return The type of link.
     */
    public LinkType getLinkType() {
        return linkType;
    }
     /**
     * Returns the type of resource, which is always ANCHOR for Anchor objects.
     *
     * @return The type of resource.
     */
    public ResourceKind getTypeOfResource() {
        return typeOfResource;
    }
}

