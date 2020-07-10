package com.xtel.training.io.bai1;

import com.xtel.training.io.bai1.utils.FileUtils;
import com.xtel.training.io.bai1.utils.NumberUtils;

import java.util.Scanner;

public class Main {

    //Đường dẫn thư mục dự án
    private static String SRC_PATH = "E:\\1. Java Core\\xtel_java_core_b1\\";
    //Đường dẫn file config
    private static String FILE_PATH = SRC_PATH + "src\\main\\java\\com\\xtel\\training\\io\\bai1\\config\\number.txt";

    private static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Number numberConfig = NumberUtils.parseDouble(FileUtils.readFirtLine(FILE_PATH));
        if (numberConfig == null) {
            System.out.println("Không tìm được số từ file:" + FILE_PATH);
            return;
        }

        boolean isEnterCorrect = false;
        for (int i = 0; i < 5; i++) {
            System.out.println("Nhập số:");
            Number numberInConsole = NumberUtils.parseDouble(SCANNER.nextLine());
            if (NumberUtils.compare(numberConfig, numberInConsole)) {
                isEnterCorrect = true;
                break;
            }
        }

        if (!isEnterCorrect) {
            System.out.println("Nhập sai!");
        } else {
            System.out.println("Thành công!");
        }
    }
}
