package com.example.student.grades;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class TXTFile {
    private static final Logger logger = Logger.getLogger(TXTFile.class.getName());

    public boolean wrtie (String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            return true;
        } catch (IOException e) {
            logger.severe("IOException occurred: " + e.getMessage());
            return false;
        }
    }
}
