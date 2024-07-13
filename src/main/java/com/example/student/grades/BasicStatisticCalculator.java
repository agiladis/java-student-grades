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

        return numbers.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    @Override
    public double median(List<Double> numbers) {
        validateInput(numbers);

        List<Double> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        int size = sortedNumbers.size();
        if (size % 2 == 0) {
            return (sortedNumbers.get(size / 2 - 1) + sortedNumbers.get(size / 2)) / 2.0;
        } else {
            return sortedNumbers.get(size / 2);
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
