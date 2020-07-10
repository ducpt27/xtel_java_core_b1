package com.xtel.io;

import com.xtel.io.utils.ConsoleUtils;
import com.xtel.io.utils.FileUtils;
import com.xtel.io.utils.NumberUtils;

public class Main {

    //Đường dẫn thư mục
    private static final String SRC_PATH = "E:\\1. Java Core\\BT1";
    private static final String FILE_PATH = SRC_PATH + "\\src\\main\\java\\com\\xtel\\io\\config\\number.txt";

    public static void main(String[] args) {
        Number number = getNumberInFile(FILE_PATH);
        if (number == null) {
            System.out.println("Không tìm được số từ file:" + FILE_PATH);
            return;
        }
        if (!compareNumberConsole(number, 5)) {
            System.out.println("Nhập lỗi");
            return;
        }
        System.out.println("Thành công!");
    }

    private static Number getNumberInFile(String f) {
        String input = FileUtils.readFirtLine(f);
        return NumberUtils.parseDouble(input);
    }

    private static boolean compareNumberConsole(Number num, int round) {
        for (int i = 0; i < round; i++) {
            Number tmp = ConsoleUtils.getNumber();
            if (tmp != null && tmp.equals(num)) {
                return true;
            }
        }
        return false;
    }
}
