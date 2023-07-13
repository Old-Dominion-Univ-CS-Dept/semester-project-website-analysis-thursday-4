package edu.odu.cs.cs350;

import java.util.regex.*;

public class Anchor {
    private String htmlRepresentation;
    private String href;
    private String text;

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
    }

    public String getHtmlRepresentation() {
        return htmlRepresentation;
    }

    public String getHref() {
        return href;
    }

    public String getText() {
        return text;
    }
}

