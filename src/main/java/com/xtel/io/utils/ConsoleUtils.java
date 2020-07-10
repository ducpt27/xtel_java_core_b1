package com.xtel.io.utils;

import java.util.Scanner;

public class ConsoleUtils {

    private static Scanner scanner = new Scanner(System.in);

    public static Number getNumber() {
        System.out.println("Nhập số:");
        return NumberUtils.parseDouble(scanner.nextLine());
    }
}