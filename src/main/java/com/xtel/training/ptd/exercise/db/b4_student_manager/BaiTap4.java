package com.xtel.training.ptd.exercise.db.b4_student_manager;

import com.xtel.training.ptd.exercise.db.b4_student_manager.config.DbConfig;
import org.apache.log4j.Logger;

public class BaiTap4 {

    protected static final Logger logger = Logger.getLogger(BaiTap4.class);

    public static void main(String[] args) {
        DbConfig dbConfig = new DbConfig("./config/db.xml");
        try {
            dbConfig.init();
        } catch (Exception e) {
            logger.error("", e);
        }

        MenuApp menuApp = new MenuApp();
        menuApp.show();
    }
}
