package com.example.student.grades;

import java.util.List;

public interface StatisticCalculator {
    double mode(List<Double> numbers);
    double mean(List<Double> numbers);
    double median(List<Double> numbers);
}
