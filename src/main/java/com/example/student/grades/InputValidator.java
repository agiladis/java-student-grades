package com.example.student.grades;

public class InputValidator {
    public static int validate(String input) throws IllegalArgumentException {
        try {
            int choice = Integer.parseInt(input);
            return choice;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input must be a number.", e);
        }
    }
}
