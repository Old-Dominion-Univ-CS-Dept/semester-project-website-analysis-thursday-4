package edu.odu.cs.cs350;

import java.net.URL;
import java.nio.file.Path;

// Resource class from outline that will be needed for what is extracted from 
// by the HTMLDocumentBuilder class. 

public class Resource
{
    ResourceKind typeOfResource; 
    Locality location; 
    long sizeOfFile; 
    Path path; 
    URL url; 
}