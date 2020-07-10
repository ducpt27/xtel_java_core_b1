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
}
