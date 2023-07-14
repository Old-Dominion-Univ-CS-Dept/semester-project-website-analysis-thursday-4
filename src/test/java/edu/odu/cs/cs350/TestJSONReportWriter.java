package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestJSONReportWriter {
    
    @Test
    public void testConstructor() {
        // Create a JSONReportWriter instance
        JSONReportWriter writer = new JSONReportWriter();

        // Verify that the output file is created and is not null
        File outputFile = writer.getOutputFile();
        assertNotNull(outputFile);
        assertEquals("src/main/data/report.json", outputFile.getPath());
    }
    

    @Test
public void testGetOutputFile() {
    // Create a JSONReportWriter instance
    JSONReportWriter writer = new JSONReportWriter();

    // Get the output file
    File outputFile = writer.getOutputFile();

    // Verify that the output file is not null
    assertNotNull(outputFile);

    // Verify that the output file name is "report.json"
    assertEquals("report.json", outputFile.getName());

     // Verify the path of the output file
     assertTrue(outputFile.getPath().contains("src/main/data/report.json"));
}

    @Test
    public void testWriteReport() {
        // Create a JSONReportWriter instance
        JSONReportWriter writer = new JSONReportWriter();

        // Create some dummy report data
        Map<String, Object> reportData = new HashMap<>();
        reportData.put("basePath", "/path/to/local/copy");
        reportData.put("urls", Arrays.asList("http://www.url1.com", "https://www.url2.com"));
    
        List<Map<String, Object>> pages = new ArrayList<>();
        Map<String, Object> page = new HashMap<>();
        page.put("path", "./some/path/to/file1.html");
        page.put("imageCount", Map.of("local", 5, "external", 2));
        page.put("jsCount", Map.of("local", 12, "external", 0));
        page.put("cssCount", Map.of("local", 2, "external", 1));
        page.put("imagePaths", Arrays.asList("path/local/image1.svg", "https://upload.wikimedia.org/wikipedia/commons/2/24/LEGO_logo.svg"));
        page.put("scriptPaths", Collections.singletonList("path/to/local/script.js"));
        page.put("cssPaths", Collections.singletonList("someLocalStyle.css"));
        page.put("linkCount", Map.of("intra-page", 5, "intra-site", 2, "external", 1));
        pages.add(page);
        reportData.put("pages", pages);

        List<Map<String, Object>> images = new ArrayList<>();
        Map<String, Object> image = new HashMap<>();
        image.put("path", "path/to/image/1.jpg");
        image.put("pageCount", 2);
        image.put("usedOn", Arrays.asList("page1.htm", "page2.htm"));
        images.add(image);
        reportData.put("images", images);

        Map<String, Object> files = new HashMap<>();
        List<Map<String, Object>> archives = new ArrayList<>();
        Map<String, Object> archive = new HashMap<>();
        archive.put("path", "files/archive1.zip");
        archive.put("size", "2 MiB");
        archives.add(archive);
        files.put("archive", archives);

        List<Map<String, Object>> videos = new ArrayList<>();
        Map<String, Object> video = new HashMap<>();
        video.put("path", "files/video1.mkv");
        video.put("size", "200 MiB");
        videos.add(video);
        files.put("video", videos);

        List<Map<String, Object>> audios = new ArrayList<>();
        Map<String, Object> audio = new HashMap<>();
        audio.put("path", "audioFile7.flac");
        audio.put("size", "10.2 MiB");
        audios.add(audio);
        files.put("audio", audios);

        List<Map<String, Object>> others = new ArrayList<>();
        Map<String, Object> other = new HashMap<>();
        other.put("path", "files/test.cpp");
        other.put("size", "0.05 MiB");
        others.add(other);
        files.put("other", others);

        reportData.put("files", files);


        // Write the report
        writer.writeReport(reportData);

        // Read the output file and check its contents
        try (BufferedReader reader = new BufferedReader(new FileReader(writer.getOutputFile()))) {
            String line = reader.readLine();
            assertTrue(line.contains("\"basePath\":\"/path/to/local/copy\""));
        } catch (IOException e) {
            fail("Error reading output file: " + e.getMessage());
        }
    }
}