package com.example.student.grades;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Getter
public class CSVFile {
    private static final String DELIMITER = ";";
    private final List<Integer> grades = new ArrayList<>();
    Logger logger = Logger.getLogger(getClass().getName());

    public void reader(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                parseLine(line);
            }
        } catch (IOException e) {
            logger.severe("IOException occurred: " + e.getMessage());
        }
    }

    private void parseLine(String line) {
        String[] values = line.split(DELIMITER);
        for (int i = 1; i < values.length; i++) {
            parseValue(values[i]);
        }
    }

    private void parseValue(String value) {
        try {
            this.grades.add(Integer.valueOf(value.trim()));
        } catch (NumberFormatException e) {
            logger.info("Invalid number format: " + value);
        }
    }
}
