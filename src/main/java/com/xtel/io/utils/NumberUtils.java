package com.xtel.io.utils;

import java.util.Scanner;

public class NumberUtils {

    public static Double parseDouble(String s) {
        if (s == null) return null;
        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            System.out.println("Không thể chuyển chuỗi thành số!");
        }
        return null;
    }

    public static boolean compare(Number n1, Number n2) {
        if (n1 == null || n2 == null) {
            return false;
        }
        if (n1.equals(n2)) {
            return true;
        }
        return false;
    }
}
