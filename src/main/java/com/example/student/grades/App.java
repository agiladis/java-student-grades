package com.example.student.grades;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean isProgramRun = false;
        do {
            mainMenu();
            System.out.print("Pilih: ");
            choice = sc.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("THANK YOU! SEE YA!");
                    isProgramRun = false;
                    break;
                case 1:
                    System.out.println("Pilih menu 1");
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
        } while (isProgramRun);
    }

    private static void mainMenu() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Aplikasi Pengolah Nilai Siswa");
        System.out.println("--------------------------------------------------------------");
        System.out.println("pilih menu:");
        System.out.println("1. Generate txt untuk menampilkan modus");
        System.out.println("2. Generate txt untuk menampilkan nilai rata-rata, median");
        System.out.println("3. Generate kedua file");
        System.out.println("0. Exit");
    }

    private static void succeedAlert(String fileDir) {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Aplikasi Pengolah Nilai Siswa");
        System.out.println("--------------------------------------------------------------");
        System.out.println("File telah di generate di " + fileDir);
        System.out.println("");
        System.out.println("0. Exit");
        System.out.println("1. Kembali ke menu utama");
    }

    private static void failedAlert() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Aplikasi Pengolah Nilai Siswa");
        System.out.println("--------------------------------------------------------------");
        System.out.println("File tidak ditemukan");
        System.out.println("");
        System.out.println("0. Exit");
        System.out.println("1. Kembali ke menu utama");
    }
}
