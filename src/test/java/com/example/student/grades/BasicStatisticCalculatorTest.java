package com.example.student.grades;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class BasicStatisticCalculatorTest {
    private BasicStatisticCalculator basicStatisticCalculator;
    private List<Double> dummyData;

    @BeforeEach
    public void setup() {
        basicStatisticCalculator = new BasicStatisticCalculator();
        dummyData = Arrays.asList(8.0, 9.0, 8.0, 9.0, 3.0, 5.0, 10.0);
    }

    @Test
    @DisplayName("Positive test - Successfull calculate mode")
    void testModeSuccess() {
        var mode = basicStatisticCalculator.mode(dummyData);
        Assertions.assertEquals(8.0, mode);
    }

    @Test
    @DisplayName("Negative test - Failed calculate mode with null")
    void testModeWithNull() {
        NullPointerException e = Assertions.assertThrows(NullPointerException.class, () -> {
            basicStatisticCalculator.mode(null);
        });
        Assertions.assertEquals("data cannot be null", e.getMessage());
    }
}
