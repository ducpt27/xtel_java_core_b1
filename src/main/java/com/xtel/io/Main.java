package com.xtel.io;

import com.xtel.common.utils.FileUtils;
import com.xtel.common.utils.NumberUtils;

import java.util.Scanner;

public class Main {

    //Đường dẫn thư mục dự án
    private static String SRC_PATH = "E:\\1. Java Core\\BT1";

    //Đường dẫn thư mục file config
    private static String FILE_PATH = SRC_PATH + "\\src\\main\\java\\com\\xtel\\io\\config\\number.txt";

    public static void main(String[] args) {
        String input = FileUtils.readFirtLine(FILE_PATH);
        Number number = NumberUtils.parseDouble(input);
        if (number == null) {
            System.out.println("Không tìm được số từ file:" + FILE_PATH);
            return;
        }

        Scanner scanner = new Scanner(System.in);
        boolean isEqual = false;
        for (int i = 0; i < 5; i++) {
            System.out.println("Nhập số:");
            Number tmp = NumberUtils.parseDouble(scanner.nextLine());
            if (NumberUtils.compare(number, tmp)) {
                isEqual = true;
                break;
            }
        }
        if (isEqual) {
            System.out.println("Thành công!");
        } else {
            System.out.println("Thất bại!");
        }
    }
}