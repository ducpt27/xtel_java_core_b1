package com.xtel.training.io_config.sort.b3_quicksort;

import com.xtel.training.common.utils.*;

public class BaiTap3 {

    //Đường dẫn thư mục dự án
    private static final String SRC_PATH = System.getProperty("user.dir");
    //Đường dẫn file các số chưa sắp xếp
    private static String FILE_PATH = SRC_PATH + "\\config\\input.txt";

    public static void main(String[] args) {
        //Đọc file
        String[] lines = FileUtils.readAllLine(FILE_PATH);

        //Chuyển dữ liệu đọc được sang mảng số nguyên
        Integer[] numbers = new Integer[0];
        for (String line : lines) {
            String[] strings = StringUtils.splitWords(line, " ");
            Integer[] newNumbers = NumberUtils.parseInt(strings);
            if (!NumberUtils.isNullOrEmpty(newNumbers)) numbers = ArrayUtils.concatenate(numbers, newNumbers);
        }

        //Sắp xếp các số theo thứ tự
        SortUtils.quicksort(numbers, false);
        for (Integer number : numbers) {
            System.out.printf(number + ", ");
        }
    }
}