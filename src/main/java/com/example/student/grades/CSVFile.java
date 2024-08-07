package com.example.student.grades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CSVFile {
    private static final String DELIMITER = ";";
    private static final Logger logger = Logger.getLogger(CSVFile.class.getName());

    public List<Double> read(String fileName) {
        List<Double> grades = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                parseLine(line, grades);
            }
        } catch (IOException e) {
            String errorMessage = "IOException occurred: " + e.getMessage();
            logger.severe(errorMessage);
            throw new FileNotFoundException(errorMessage);
        }

        return grades;
    }

    private void parseLine(String line, List<Double> grades) {
        String[] values = line.split(DELIMITER);
        for (int i = 1; i < values.length; i++) {
            parseValue(values[i], grades);
        }
    }

    private void parseValue(String value, List<Double> grades) {
        try {
            grades.add(Double.valueOf(value.trim()));
        } catch (NumberFormatException e) {
            logger.info("Invalid number format: " + value);
        }
    }
}
