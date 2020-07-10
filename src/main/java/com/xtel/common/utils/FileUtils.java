package com.xtel.common.utils;

import java.io.File;
import java.util.Scanner;

public class FileUtils {

    public static String readFirtLine(String fp) {
        String s = null;
        try {
            File f = new File(fp);
            if (f.exists() && f.canRead()) {
                Scanner scanner = new Scanner(f);
                if (scanner.hasNextLine()) {
                    s = scanner.nextLine();
                }
                scanner.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
