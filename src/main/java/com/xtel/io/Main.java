package com.xtel.io;

import com.xtel.io.utils.FileUtils;
import com.xtel.io.utils.NumberUtils;

import java.util.Scanner;

public class Main {

    //Đường dẫn thư mục
    private static final String SRC_PATH = "E:\\1. Java Core\\BT1";
    private static final String FILE_PATH = SRC_PATH + "\\src\\main\\java\\com\\xtel\\io\\config\\number.txt";

    public static void main(String[] args) {
        String input = FileUtils.readFirtLine(FILE_PATH);
        Number number = NumberUtils.parseDouble(input);
        if (number == null) {
            System.out.println("Không tìm được số từ file:" + FILE_PATH);
            return;
        }

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Nhập số:");
            Number tmp = NumberUtils.parseDouble(scanner.nextLine());
            if (NumberUtils.compare(number, tmp)) {
                System.out.println("Thành công!");
                break;
            } else {
                System.out.println("Nhập sai!");
            }
        }
    }
}
