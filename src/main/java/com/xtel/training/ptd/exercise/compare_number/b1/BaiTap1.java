package com.xtel.training.ptd.exercise.compare_number.b1;

import com.xtel.training.ptd.common.utils.FileUtils;
import com.xtel.training.ptd.common.utils.NumberUtils;

import java.util.Scanner;

public class BaiTap1 {

    //Đường dẫn thư mục dự án
    private static final String SRC_PATH = System.getProperty("user.dir");
    //Đường dẫn file config
    private static String FILE_PATH = SRC_PATH + "\\config\\number.txt";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Number numberConfig = null;
        try {
            numberConfig = NumberUtils.parseDouble(FileUtils.readLine(FILE_PATH, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (numberConfig == null) {
            System.out.println("Không tìm được số từ file:" + FILE_PATH);
            return;
        }

        boolean isEnterCorrect = false;
        for (int i = 0; i < 5; i++) {
            System.out.println("Nhập số:");
            Double numberInConsole = null;
            try {
                numberInConsole = NumberUtils.parseDouble(SCANNER.nextLine());
            } catch (Exception e) {
                e.printStackTrace();
            }
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
