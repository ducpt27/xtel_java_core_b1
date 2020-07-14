package com.xtel.training.ptd.exercise.db.b4_student_manager;

import com.xtel.training.ptd.exercise.db.b4_student_manager.config.DbConfig;

public class BaiTap4 {

    public static void main(String[] args) {
        DbConfig dbConfig = new DbConfig("./config/db.xml");
        try {
            dbConfig.init();
        } catch (Exception e) {
            e.printStackTrace();
        }

        MenuApp menuApp = new MenuApp();
        menuApp.show();
    }
}
