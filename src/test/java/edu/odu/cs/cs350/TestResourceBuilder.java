package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;



public class TestResourceBuilder {

    @Test
    public void testResolveRelativePath() {
        ResourceBuilder resourceBuilder = new ResourceBuilder("../../Public/sshLab/");
        String result = resourceBuilder.resolveRelativePath("./index.html");
        assertThat(result, is("Public/sshLab/index.html"));
    }
}