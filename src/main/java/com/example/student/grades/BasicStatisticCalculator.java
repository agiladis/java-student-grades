package com.example.student.grades;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicStatisticCalculator implements StatisticCalculator {

    @Override
    public double mode(List<Double> numbers) {
        Map<Double, Integer> frequencyNumbers = new HashMap<>();
        for (double number : numbers) {
            frequencyNumbers.put(number, frequencyNumbers.getOrDefault(number, 0) + 1);
        }

        double mode = 0;
        int maxFrequency = -1;
        for (Map.Entry<Double, Integer> entry : frequencyNumbers.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mode = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        return mode;
    }

    @Override
    public double mean(List<Double> numbers) {
        return 0;
    }

    @Override
    public double median(List<Double> numbers) {
        return 0;
    }
}
