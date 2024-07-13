package com.example.student.grades;

import java.util.*;

public class BasicStatisticCalculator implements StatisticCalculator {

    @Override
    public double mode(List<Double> numbers) {
        if (numbers == null) {
            throw new NullPointerException("data cannot be null");
        }

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
        if (numbers == null) {
            throw new NullPointerException("data cannot be null");
        }

        double sumOfNumber = 0;
        for (double number : numbers) {
            sumOfNumber += number;
        }

        return sumOfNumber/numbers.size();
    }

    @Override
    public double median(List<Double> numbers) {
        if (numbers == null) {
            throw new NullPointerException("data cannot be null");
        }

        Collections.sort(numbers);

        int numbersSize = numbers.size();
        if (numbersSize % 2 == 0) {
            int index1 = numbersSize / 2 - 1;
            int index2 = numbersSize / 2;

            return  (numbers.get(index1) + numbers.get(index2)) / 2;
        } else {
            int index = numbersSize / 2;

            return numbers.get(index);
        }
    }

    @Override
    public Map<String, Integer> frequencyDistribution(List<Double> numbers) {
        Collections.sort(numbers);
        Map<String, Integer> frequencyDistributionData = new LinkedHashMap<>();

        for (double number : numbers) {
            if (number < 6.0) {
                frequencyDistributionData.put("<6.0", frequencyDistributionData.getOrDefault("<6.0", 0) + 1);
            } else {
                String key = String.valueOf(number);
                frequencyDistributionData.put(key, frequencyDistributionData.getOrDefault(key, 0) + 1);
            }
        }

        return frequencyDistributionData;
    }
}
