package com.xtel.training.io.bai2;

import com.xtel.training.common.utils.NumberUtils;
import com.xtel.training.io.bai2.model.Electric;

import java.util.Scanner;

public class Main {

    private static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Nhập số điện:");
        Double electricNum = NumberUtils.parseDouble(SCANNER.nextLine());
        if (electricNum == null || electricNum < 0) {
            System.out.println("Nhập sai số điện!");
            return;
        }

        Electric electric = new Electric(electricNum);
        System.out.println("Tổng tiền điện:" + electric.getTotalPrice());
    }
}