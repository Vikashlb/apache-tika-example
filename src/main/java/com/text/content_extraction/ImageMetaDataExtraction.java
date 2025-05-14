package com.text.content_extraction;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;

import java.io.File;
import java.io.FileInputStream;

public class ImageMetaDataExtraction {
    public static void main(String[] args) {
        try{
            File imageFile = new File("devon-logo-blue.png");
            FileInputStream input = new FileInputStream(imageFile);

            //BodyContentHandler extracts the content from the body of the file
            ContentHandler handler = new BodyContentHandler();

            //Metadata stores the metadata in key-value of the file
            Metadata metadata = new Metadata();

            //AutoDetectParser detects the file type and uses specific parser accordingly
            AutoDetectParser parser = new AutoDetectParser();
            parser.parse(input, handler, metadata);

            // Print all metadata
            System.out.println("Extracted Metadata:");
            for (String name : metadata.names()) {
                System.out.println(name + " : " + metadata.get(name));
            }

            input.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
