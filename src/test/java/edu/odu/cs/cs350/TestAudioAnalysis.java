package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TestAudioAnalysis {

    @Test
    public void testAnalyzeAudio_ValidFile() throws IOException {
        String audioFilePath = "audioTests.mp3"; // Replace with the path to a valid audio file
        AudioAnalysis.AudioInfo audioInfo = AudioAnalysis.analyzeAudio(audioFilePath);

        assertNotNull(audioInfo);
        assertNotNull(audioInfo.getFileType());
        assertNotNull(audioInfo.getFileSize());
        assertNotNull(audioInfo.getAudioPath());
        assertEquals("mp3", audioInfo.getFileType());
    }

    @Test
    public void testAnalyzeAudio_UnsupportedFormat() throws IOException {
        String audioFilePath = "audioTest.mp3"; 
        try {
            AudioAnalysis.analyzeAudio(audioFilePath);
        } catch(IOException e) {
            System.out.println(e);
        }

    }

    //
}
