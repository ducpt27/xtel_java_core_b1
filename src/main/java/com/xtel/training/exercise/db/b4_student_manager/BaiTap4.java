package com.xtel.training.exercise.db.b4_student_manager;

import com.xtel.training.common.utils.NumberUtils;
import com.xtel.training.common.utils.StringUtils;
import com.xtel.training.exercise.db.b4_student_manager.database.ConnectionFactory;
import com.xtel.training.exercise.db.b4_student_manager.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BaiTap4 {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Connection conn = ConnectionFactory.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO Student (full_name, age, hometown, gender) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        try {
            statement.setString(1, "");
            statement.setString(2, "");
            statement.setString(3, "");
            statement.setString(4, "");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        int rowsInserted = 0;
        try {
            rowsInserted = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }


        Integer choose;
        do {
            showMenu();
            choose = NumberUtils.parseInt(SCANNER.nextLine());
            if (choose == null) choose = 0;
            switch (choose) {
                case 1:
                    newStudent();
                case 2:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Chọn số [1-2]!");
                    break;
            }
        } while (choose != 2);
    }

    private static void newStudent() {
        Student std = new Student();

        System.out.println("Nhập tên: ");
        std.setFullName(SCANNER.nextLine());

        System.out.println("Nhập quê quán: ");
        std.setHomeTown(SCANNER.nextLine());

        System.out.println("Nhập tuổi: ");
        std.setAge(NumberUtils.parseInt(SCANNER.nextLine()));

        System.out.println("Giới tính: Nam[y]/Nữ[n]");
        String strGender = SCANNER.nextLine();
        if (!StringUtils.isNullOrEmpty(strGender) && strGender.trim().toLowerCase().equals("y")) {
            std.setGender(false);
        } else {
            std.setGender(true);
        }
    }

    private static void showMenu() {
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Thoát");
        System.out.println("Chọn: ");
    }
}
