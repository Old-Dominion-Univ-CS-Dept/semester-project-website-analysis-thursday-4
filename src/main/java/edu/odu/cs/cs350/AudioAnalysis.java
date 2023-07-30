package edu.odu.cs.cs350;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.apache.tika.parser.mp4.MP4Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

public class AudioAnalysis {

    public static void main(String[] args) {
        String audioFilePath = "NastyC-Mrs-Me.mp3"; // the path to audio file

        try {
            AudioInfo audioInfo = analyzeAudio(audioFilePath);
            System.out.println(audioInfo.toJSON());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AudioInfo analyzeAudio(String filePath) throws IOException {
        File file = new File(filePath);
        String fileType = getFileType(file.getName());

        Parser parser;
        switch (fileType) {
            case "mp3":
                parser = new Mp3Parser();
                break;
            case "mp4":
                parser = new MP4Parser();
                break;
            // case "ogg":
            //     parser = new OggParser();
            //     break;
            // case "wav":
            //     parser = new WavParser();
            //     break;
            default:
                throw new IllegalArgumentException("Unsupported audio file format");
        }

        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        ParseContext parseContext = new ParseContext();
        try (FileInputStream inputStream = new FileInputStream(file)) {
            parser.parse(inputStream, handler, metadata, parseContext);
        } catch (SAXException | TikaException e) {
                throw new IOException("Error parsing the audio file: " + e.getMessage());
            }

        String fileSize = Long.toString(file.length());
        String audioPath = file.getAbsolutePath();

        return new AudioInfo(fileType, fileSize, audioPath);
    }

    private static String getFileType(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex != -1 && lastDotIndex < fileName.length() - 1) {
            return fileName.substring(lastDotIndex + 1).toLowerCase();
        }
        return "";
    }
    public class AudioInfo {
    private final String fileType;
    private final String fileSize;
    private final String audioPath;

    public AudioInfo(String fileType, String fileSize, String audioPath) {
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.audioPath = audioPath;
    }

    public String toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fileType", fileType);
        jsonObject.put("fileSize", fileSize);
        jsonObject.put("audioPath", audioPath);
        return jsonObject.toString(4); // Use indentation of 4 spaces for pretty printing
    }
}
    @Override
    public String toString() {
        return "AudioAnalysis []";
    }
}
