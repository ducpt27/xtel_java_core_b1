package com.xtel.training.io.bai1.utils;

import java.io.File;
import java.util.Scanner;

public class FileUtils {

    public static String readFirtLine(String filePath) {
        String firstLine = null;
        try {
            File f = new File(filePath);
            if (f.exists() && f.canRead()) {
                Scanner scannerFile = new Scanner(f);
                if (scannerFile.hasNextLine()) {
                    firstLine = scannerFile.nextLine();
                }
                scannerFile.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return firstLine;
    }
}
