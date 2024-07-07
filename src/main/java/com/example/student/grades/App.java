package com.example.student.grades;

public class App {
    public static void main(String[] args) {

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
