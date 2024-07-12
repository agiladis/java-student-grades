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
    private List<Double> singelDummyData;

    @BeforeEach
    public void setup() {
        basicStatisticCalculator = new BasicStatisticCalculator();
        dummyData = Arrays.asList(8.0, 9.0, 8.0, 9.0, 3.0, 5.0, 10.0);
        singelDummyData = Arrays.asList(2.0);
    }

    @Test
    @DisplayName("Positive test - Successfull calculate mode")
    void testModeSuccess() {
        Assertions.assertEquals(8.0, basicStatisticCalculator.mode(dummyData));
        Assertions.assertEquals(2.0, basicStatisticCalculator.mode(singelDummyData));
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
        NullPointerException e = Assertions.assertThrows(NullPointerException.class, () -> {
            basicStatisticCalculator.mode(null);
        });
        Assertions.assertEquals("data cannot be null", e.getMessage());
    }
}
