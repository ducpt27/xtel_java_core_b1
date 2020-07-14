package com.xtel.training.ptd.exercise.db.b4_student_manager;

import com.xtel.training.ptd.common.utils.NumberUtils;
import com.xtel.training.ptd.common.utils.StringUtils;
import com.xtel.training.ptd.exercise.db.b4_student_manager.config.DbConfig;
import com.xtel.training.ptd.exercise.db.b4_student_manager.db.DbModule;
import com.xtel.training.ptd.exercise.db.b4_student_manager.model.cmd.DbStudentInsertCmd;
import com.xtel.training.ptd.exercise.db.b4_student_manager.model.cmd.DbStudentNameExistCmd;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class MenuApp {

    protected static final Logger logger = Logger.getLogger(MenuApp.class);

    public static final Scanner SCANNER = new Scanner(System.in);

    static DbModule dbModule = new DbModule();

    public MenuApp() {
    }

    public void show() {
        Integer choose;
        do {
            showMenu();
            try {
                choose = NumberUtils.parseInt(SCANNER.nextLine());
            } catch (Exception e) {
                logger.error("", e);
                choose = 0;
            }
            if (choose == null) choose = 0;
            switch (choose) {
                case 1:
                    showAddStudent();
                    break;
                case 2:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Chọn số [1-2]!");
                    break;
            }
        } while (choose != 2);
    }

    private boolean checkNameExits(String full_name) {
        DbStudentNameExistCmd dbStudentNameExistCmd = new DbStudentNameExistCmd(full_name);
        try {
            dbModule.execute(dbStudentNameExistCmd);
            return dbStudentNameExistCmd.isNameIsExist();
        } catch (Exception e) {
            logger.error("", e);
        }
        return true;
    }

    private void newStudent(String full_name, int age, String hometown, boolean gender) {
        DbStudentInsertCmd dbStudentInsertCmd = new DbStudentInsertCmd(full_name, age, hometown, gender);
        try {
            dbModule.execute(dbStudentInsertCmd);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    private void showAddStudent() {
        System.out.println("Nhập tên:");
        String full_name = SCANNER.nextLine();

        if (checkNameExits(full_name) || StringUtils.isNullOrEmpty(full_name)) {
            System.out.println("Tên không đúng hoặc đã tồn tại! Nhập lại!");
            showAddStudent();
            return;
        }

        System.out.println("Giới tính[Y]: Nam[Y]/Nữ[n]");
        String strGender = SCANNER.nextLine();
        boolean gender = (!StringUtils.isNullOrEmpty(strGender) && strGender.trim().toLowerCase().equals("n"));

        Integer age = 0;
        while (age <= 0 || age > 1000) {
            System.out.println("Nhập tuổi:");
            try {
                Integer var1 = NumberUtils.parseInt(SCANNER.nextLine());
                if (var1 != null) age = var1;
            } catch (Exception e) {
                logger.error("", e);
                System.out.println("Nhập sai!");
            }
        }

        System.out.println("Nhập quê quán:");
        String hometown = SCANNER.nextLine();

        newStudent(full_name, age, hometown, gender);
    }

    private void showMenu() {
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Thoát");
        System.out.println("Chọn: ");
    }
}