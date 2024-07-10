package com.example.student.grades;

import java.util.List;
import java.util.Map;

public interface StatisticCalculator {
    double mode(List<Double> numbers);
    double mean(List<Double> numbers);
    double median(List<Double> numbers);
    Map<String, Integer> frequencyDistribution(List<Double> numbers);
}
