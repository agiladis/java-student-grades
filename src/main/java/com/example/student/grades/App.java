package com.example.student.grades;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor // Dependency Injection CSVFile and Scanner
public class App {
    private static final String SCHOOL_FILE_PATH = Configuration.getProperty("school.file.path");

    private final CSVFile csvFile;
    private final Scanner scanner;

    public void run() {
        boolean isProgramRunning = true;

        while (isProgramRunning) {
            printMainMenu();
            System.out.print("Pilih: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("THANK YOU! SEE YA!");
                    isProgramRunning = false;
                    break;
                case 1:
                    calculateAndGenerateModusTxt();
                    break;
                case 2:
                    System.out.println("Pilih menu 2");
                    break;
                case 3:
                    System.out.println("Pilih menu 3");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }

    private void calculateAndGenerateModusTxt() {
        List<Double> grades;
        StatisticCalculator statisticCalculator = new BasicStatisticCalculator();

        grades = csvFile.read(SCHOOL_FILE_PATH);
        double mode = statisticCalculator.mode(grades);
        printSucceedAlert("belum generate");
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
        System.out.println("File telah di generate di " + fileDir);
        System.out.println("");
        System.out.println("0. Exit");
        System.out.println("1. Kembali ke menu utama");
    }

    private void printFailedAlert() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Aplikasi Pengolah Nilai Siswa");
        System.out.println("--------------------------------------------------------------");
        System.out.println("File tidak ditemukan");
        System.out.println("");
        System.out.println("0. Exit");
        System.out.println("1. Kembali ke menu utama");
    }

    public static void main(String[] args) {
        CSVFile csvFile = new CSVFile();
        Scanner scanner = new Scanner(System.in);
        App app = new App(csvFile, scanner);
        app.run();
        scanner.close();
    }
}
