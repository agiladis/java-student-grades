package com.example.student.grades;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@AllArgsConstructor // Dependency Injection CSVFile and Scanner
public class App {
    private static final String SCHOOL_FILE_PATH = Configuration.getProperty("school.file.path");
    private static final String STATISTICS_FILE_PATH = Configuration.getProperty("statistic.file.path");
    private static final String FREQUENCY_FILE_PATH = Configuration.getProperty("frequency.file.path");
    private static final String REPORT_FILE_PATH = Configuration.getProperty("report.file.path");

    private final CSVFile csvFile;
    private final TXTFile txtFile;
    private final Scanner scanner;
    private final StatisticCalculator basicStatisticCalculator;

    public void run() {
        boolean isProgramRunning = true;

        while (isProgramRunning) {
            printMainMenu();
            System.out.print("Pilih: ");
            int choice = scanner.nextInt();
            int secondChoice;

            switch (choice) {
                case 0:
                    isProgramRunning = false;
                    break;
                case 1:
                    generateFrequencyDataFile();
                    handlePostGenerationMenu();
                    break;
                case 2:
                    generateMeanMedianModeFile();
                    handlePostGenerationMenu();
                    break;
                case 3:
                    generateReportFile();
                    handlePostGenerationMenu();
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }

        goodbyeMessage();
    }

    private void handlePostGenerationMenu() {
        boolean isSubMenuRunning = true;

        while (isSubMenuRunning) {
            System.out.print("Pilih: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    goodbyeMessage();
                    System.exit(0);
                    break;
                case 1:
                    isSubMenuRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }

    private void generateReportFile() {
        List<Double> data = csvFile.read(SCHOOL_FILE_PATH);
        Map<String, Integer> frequencyDistributionMap = basicStatisticCalculator.frequencyDistribution(data);
        double mean = basicStatisticCalculator.mean(data);
        double median = basicStatisticCalculator.median(data);
        double mode = basicStatisticCalculator.mode(data);

        // content of file txt
        StringBuilder content = new StringBuilder();
        content.append("Berikut Hasil Rekap Nilai Ujian Sekolah\n\n");

        // Statistical values
        content.append(String.format("Mean\t\t: %.2f%n", mean));
        content.append(String.format("Modus\t\t: %.2f%n", mode));
        content.append(String.format("Median\t\t: %.2f%n%n", median));

        // Frequency distribution header
        content.append("Sebaran Nilai Seluruh Siswa:\n");
        content.append(String.format("%-10s |\t Frekuensi%n", "Nilai"));

        // Frequency distribution values
        frequencyDistributionMap.forEach((value, frequency) -> content.append(String.format("%-10s |\t %d %n", value, frequency)));

        // write file
        if (txtFile.wrtie(REPORT_FILE_PATH, content.toString())) {
            printSucceedAlert(REPORT_FILE_PATH);
        } else {
            printFailedAlert();
        }
    }

    private void generateMeanMedianModeFile() {
        List<Double> data = csvFile.read(SCHOOL_FILE_PATH);
        double mean = basicStatisticCalculator.mean(data);
        double median = basicStatisticCalculator.median(data);
        double mode = basicStatisticCalculator.mode(data);

        // content of file txt
        StringBuilder content = new StringBuilder();
        content.append("Berikut Hasil Pengolahan Nilai:\n\n");
        content.append("Berikut hasil sebaran data nilai\n");
        content.append(String.format("Mean: %.2f%n", mean));
        content.append(String.format("Median: %.2f%n", median));
        content.append(String.format("Modus: %.2f%n", mode));

        if (txtFile.wrtie(STATISTICS_FILE_PATH, content.toString())) {
            printSucceedAlert(STATISTICS_FILE_PATH);
        } else {
            printFailedAlert();
        }
    }

    private void generateFrequencyDataFile() {
        List<Double> data = csvFile.read(SCHOOL_FILE_PATH);
        Map<String, Integer> frequencyDistributionMap = basicStatisticCalculator.frequencyDistribution(data);

        // content of file txt
        StringBuilder content = new StringBuilder();
        content.append("Berikut Hasil Pengolahan Nilai:\n\n");
        content.append(String.format("%-10s |\t Frekuensi%n", "Nilai"));

        frequencyDistributionMap.forEach((value, frequency) -> content.append(String.format("%-10s |\t %d %n", value, frequency)));

        if (txtFile.wrtie(FREQUENCY_FILE_PATH, content.toString())) {
            printSucceedAlert(FREQUENCY_FILE_PATH);
        } else {
            printFailedAlert();
        }
    }

    private void printMainMenu() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Aplikasi Pengolah Nilai Siswa");
        System.out.println("--------------------------------------------------------------");
        System.out.println("pilih menu:");
        System.out.println("1. Generate txt untuk menampilkan modus");
        System.out.println("2. Generate txt untuk menampilkan nilai rata-rata, median");
        System.out.println("3. Generate kedua file");
        System.out.println("0. Exit");
    }

    private void printSucceedAlert(String fileDir) {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Aplikasi Pengolah Nilai Siswa");
        System.out.println("--------------------------------------------------------------");
        System.out.println("File telah di generate di " + fileDir + "\n");
        System.out.println("0. Exit");
        System.out.println("1. Kembali ke menu utama");
    }

    private void printFailedAlert() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Aplikasi Pengolah Nilai Siswa");
        System.out.println("--------------------------------------------------------------");
        System.out.println("File tidak ditemukan" + "\n");
        System.out.println("0. Exit");
        System.out.println("1. Kembali ke menu utama");
    }

    private void goodbyeMessage() {
        System.out.println("THANK YOU! SEE YA!");
    }

    public static void main(String[] args) {
        CSVFile csvFile = new CSVFile();
        TXTFile txtFile = new TXTFile();
        Scanner scanner = new Scanner(System.in);
        StatisticCalculator basicStatisticCalculator = new BasicStatisticCalculator();

        App app = new App(csvFile, txtFile, scanner, basicStatisticCalculator);
        app.run();
        scanner.close();
    }
}
