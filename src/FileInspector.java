// FileInspector.java

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("src")); // Start in src folder

        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    lineCount++;
                    String[] words = line.trim().split("\\s+");
                    if (!line.trim().isEmpty()) {
                        wordCount += words.length;
                    }
                    charCount += line.length();
                }

                System.out.println("\nSummary Report:");
                System.out.println("File: " + selectedFile.getName());
                System.out.println("Lines: " + lineCount);
                System.out.println("Words: " + wordCount);
                System.out.println("Characters: " + charCount);

            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}