package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestResourceBuilder {

    @Test
    public void testResolveRelativePath() {
        ResourceBuilder resourceBuilder = new ResourceBuilder(Paths.get("/Public/sshLab/subdir/"));
        Path result = resourceBuilder.resolveRelativePath(Paths.get("./index.html"));
        assertThat(result.toString(), is("/Public/sshLab/subdir/index.html"));
    }
}
