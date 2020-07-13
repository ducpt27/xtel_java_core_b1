package com.xtel.training.io_config.db.b4_student_manager;

import com.xtel.training.io_config.db.b4_student_manager.database.ConnectionFactory;

import java.sql.Connection;

public class BaiTap4 {

    public static void main(String[] args) {
        try {
            Connection conn = ConnectionFactory.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
