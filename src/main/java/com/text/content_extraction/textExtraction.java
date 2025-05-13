package com.text.content_extraction;

import org.apache.tika.Tika;

import java.io.File;

public class textExtraction {
    public static void main(String[] args) {
        Tika tika = new Tika();
        File file = new File("TestSanitize.docx");
        try {
            String text = tika.parseToString(file);
            System.out.println("Extracted Text :\n"+ text);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
