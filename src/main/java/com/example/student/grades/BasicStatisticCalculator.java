package com.example.student.grades;

import java.util.*;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class BasicStatisticCalculator implements StatisticCalculator {

    @Override
    public double mode(List<Double> numbers) {
        validateInput(numbers);

        Map<Double, Long> frequencyNumbers = numbers.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        return frequencyNumbers.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new IllegalArgumentException("no mode found"))
                .getKey();


    }

    @Override
    public double mean(List<Double> numbers) {
        validateInput(numbers);

        double sumOfNumber = 0;
        for (double number : numbers) {
            sumOfNumber += number;
        }

        return sumOfNumber/numbers.size();
    }

    @Override
    public double median(List<Double> numbers) {
        validateInput(numbers);

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

    private void validateInput(List<Double> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("data cannot be empty");
        }
    }
}
