package com.xtel.training.common.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtils {

    public static String readLine(String filePath, int lineIndex) {
        try {
            File f = new File(filePath);
            if (canRead(f)) {
                Scanner scanner = new Scanner(f);
                int i = 0;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (i == lineIndex) return line;
                    i++;
                }
                scanner.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String[] readAllLine(String filePath) {
        ArrayList<String> arr = new ArrayList<>();
        try {
            File f = new File(filePath);
            if (canRead(f)) {
                Scanner scanner = new Scanner(f);
                while (scanner.hasNextLine()) {
                    arr.add(scanner.nextLine());
                }
                scanner.close();
            }
            String[] lines = new String[arr.size()];
            return arr.toArray(lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean canRead(File file) {
        return (file.isFile() && file.exists() && file.canRead());
    }
}
