package com.xtel.io;

import java.io.*;
import java.util.Scanner;

public class Main {

    //Sửa đường dẫn gốc
    private static final String SRC_PATH = "E:\\1. Java Core\\BT1";
    private static final String FILE_PATH = SRC_PATH + "\\src\\main\\java\\com\\xtel\\io\\config\\number.txt";

    public static void main(String[] args) {
        //Đọc file
        try {
            File file = new File(FILE_PATH);
            if (!file.exists() || !file.canRead()) {
                System.out.println("Không đọc được file: " + FILE_PATH);
            } else {
                Scanner scanner = new Scanner(file);
                if (scanner.hasNextLine()) {
                    String s = scanner.nextLine();
                    try {
                        Double number = Double.parseDouble(s);
                        compareNumber(number);
                    } catch (NumberFormatException e) {
                        System.out.println("Dữ liệu đầu vào phải là số.");
                    }
                } else {
                    System.out.println("File rỗng!");
                }
                scanner.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void compareNumber(double number) {
        //Nhập số từ console và so sánh với đầu vào
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("Nhập số:");
                Double input = Double.parseDouble(scanner.nextLine());
                if (input.equals(number)) {
                    System.out.println("Thành công!");
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Nhập sai!");
        }
        scanner.close();
        System.out.println("Bạn đã nhập sai quá 5 lần!");
        System.exit(0);
    }
}
