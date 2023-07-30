package edu.odu.cs.cs350;


/**
 * Manage the creation of Resource objects with the builder pattern.
 * It encapsulates all resource setup logic including type determination, URL-path conversion, file size calculation
 * for local resources, and path and URL normalization. Deferring object creation until all necessary data is acquired.
 */


public class ResourceBuilder {
    private String sourceDocumentPath;

    /**
     * Constructs a new ResourceBuilder with path.
     *
     * @param sourceDocumentPath the path to the source document
     */
    public ResourceBuilder(String sourceDocumentPath) {
        this.sourceDocumentPath = sourceDocumentPath;
    }

    /**
     * Resolves a relative path to an absolute path.
     *
     * @param relativePath the relative path to be resolved
     * @return resolved absolute path
     */
    public String resolveRelativePath(String relativePath) {
        
        return null; // will replace later in development
    }
}