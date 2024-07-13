package com.example.student.grades;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class BasicStatisticCalculatorTest {
    private BasicStatisticCalculator basicStatisticCalculator;
    private List<Double> dummyData;
    private List<Double> singleDummyData;

    @BeforeEach
    public void setup() {
        basicStatisticCalculator = new BasicStatisticCalculator();
        dummyData = Arrays.asList(8.0, 9.0, 8.0, 9.0, 3.0, 5.0, 10.0);
        singleDummyData = Collections.singletonList(2.0);
    }

    @Test
    @DisplayName("Positive test - Successfull calcculate mean")
    void testMeanSuccess() {
        BigDecimal bd = new BigDecimal(Double.toString(basicStatisticCalculator.mean(dummyData)));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        Assertions.assertEquals(7.43, bd.doubleValue());
    }

    @Test
    @DisplayName("Positive test - Successful calculate mean with single data point")
    void testMeanWithSingleDataPoint() {
        Assertions.assertEquals(2.0, basicStatisticCalculator.mean(singleDummyData));
    }

    @Test
    @DisplayName("Positive test - Successfull calculate mode")
    void testModeSuccess() {
        Assertions.assertEquals(8.0, basicStatisticCalculator.mode(dummyData));
    }

    @Test
    @DisplayName("Positive test - Successful calculate mode with single data point")
    void testModeWithSingleDataPoint() {
        Assertions.assertEquals(2.0, basicStatisticCalculator.mode(singleDummyData));
    }

    @Test
    @DisplayName("Positive test - Successfull calculate mode with unique data")
    void testModeWithUniqueData() {
        List<Double> uniqueData = Arrays.asList(4.0, 3.0, 1.0, 5.0, 6.0, 2.0);
        Assertions.assertEquals(4.0, basicStatisticCalculator.mode(uniqueData));
    }

    @Test
    @DisplayName("Negative test - Failed calculate mode with null")
    void testModeWithNull() {
        NullPointerException e = Assertions.assertThrows(NullPointerException.class, () -> basicStatisticCalculator.mode(null));
        Assertions.assertEquals("data cannot be null", e.getMessage());
    }
}
