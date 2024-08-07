package com.example.student.grades;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CSVFileTest {

    @Test
    @DisplayName("Negative test - Failed to find csv file")
    void testFileNotFound() {
        CSVFile csvFile = new CSVFile();

        Executable executable = () -> csvFile.read("non_existent_file.csv");

        FileNotFoundException e = assertThrows(FileNotFoundException.class, executable);
        assertTrue(e.getMessage().contains("IOException occurred"));
    }
}
