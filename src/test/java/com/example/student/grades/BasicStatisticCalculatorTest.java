package com.example.student.grades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BasicStatisticCalculatorTest {
    private BasicStatisticCalculator basicStatisticCalculator;
    private List<Double> dummyData;
    private List<Double> evenDummyData;
    private List<Double> singleDummyData;
    private List<Double> emptyDummyData;


    @BeforeEach
    public void setup() {
        basicStatisticCalculator = new BasicStatisticCalculator();
        dummyData = Arrays.asList(8.0, 9.0, 8.0, 9.0, 3.0, 5.0, 10.0);
        evenDummyData = Arrays.asList(8.0, 9.0, 8.0, 9.0, 3.0, 5.0, 10.0, 10.0);
        singleDummyData = Collections.singletonList(2.0);
        emptyDummyData = Arrays.asList();
    }

    @Test
    @DisplayName("Positive test - successful test frequency distribution")
    void testFrequencyDistribution() {
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("<6.0", 2);
        expected.put("8.0", 2);
        expected.put("9.0", 2);
        expected.put("10.0", 1);
        assertEquals(expected, basicStatisticCalculator.frequencyDistribution(dummyData));
    }

    @Test
    @DisplayName("Positive test - Successful calculate median with odd number of elements")
    void testMedianWithOddNumbersOfElements() {
        assertEquals(8.0, basicStatisticCalculator.median(dummyData));
    }

    @Test
    @DisplayName("Positive test - Successful calculate median with even even number of elements")
    void testMedianWithEvenNumbersOfElements() {
        assertEquals(8.5, basicStatisticCalculator.median(evenDummyData));
    }

    @Test
    @DisplayName("Positive test - Successful calculate median with single data point")
    void testMedianWithSingleDataPoint() {
        assertEquals(2.0, basicStatisticCalculator.median(singleDummyData));
    }

    @Test
    @DisplayName("Negative test - Failed calculate mean with empty list")
    void testMedianWithEmptyList() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> basicStatisticCalculator.median(emptyDummyData));
        assertEquals("data cannot be null or empty", e.getMessage());
    }

    @Test
    @DisplayName("Negative test - Failed calculate mean with null")
    void testMedianWithNullData() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> basicStatisticCalculator.median(null));
        assertEquals("data cannot be null or empty", e.getMessage());
    }

    @Test
    @DisplayName("Positive test - Successful calculate mean")
    void testMeanSuccess() {
        double result = basicStatisticCalculator.mean(dummyData);
        assertEquals(7.43, result, 0.01);
    }

    @Test
    @DisplayName("Positive test - Successful calculate mean with single data point")
    void testMeanWithSingleDataPoint() {
        assertEquals(2.0, basicStatisticCalculator.mean(singleDummyData));
    }

    @Test
    @DisplayName("Negative test - Failed calculate mean with empty list")
    void testMeanWithEmptyList() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> basicStatisticCalculator.mean(emptyDummyData));
        assertEquals("data cannot be null or empty", e.getMessage());
    }

    @Test
    @DisplayName("Negative test - Failed calculate mean with null")
    void testMeanWithNull() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> basicStatisticCalculator.mean(null));
        assertEquals("data cannot be null or empty", e.getMessage());
    }

    @Test
    @DisplayName("Positive test - Successful calculate mode")
    void testModeSuccess() {
        assertEquals(8.0, basicStatisticCalculator.mode(dummyData));
    }

    @Test
    @DisplayName("Positive test - Successful calculate mode with single data point")
    void testModeWithSingleDataPoint() {
        assertEquals(2.0, basicStatisticCalculator.mode(singleDummyData));
    }

    @Test
    @DisplayName("Positive test - Successful calculate mode with unique data")
    void testModeWithUniqueData() {
        List<Double> uniqueData = Arrays.asList(1.0, 1.0, 2.0, 2.0, 3.0, 3.0);
        assertEquals(2.0, basicStatisticCalculator.mode(uniqueData));
    }

    @Test
    @DisplayName("Negative test - Failed calculate mode with empty list")
    void testModeWithEmptyList() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> basicStatisticCalculator.mode(emptyDummyData));
        assertEquals("data cannot be null or empty", e.getMessage());
    }

    @Test
    @DisplayName("Negative test - Failed calculate mode with null")
    void testModeWithNull() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> basicStatisticCalculator.mode(null));
        assertEquals("data cannot be null or empty", e.getMessage());
    }
}
