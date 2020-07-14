package com.xtel.training.ptd.exercise.db.b4_student_manager.db;


import com.mysql.cj.jdbc.ConnectionWrapper;
import com.xtel.training.ptd.exercise.db.b4_student_manager.config.DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static String dbType;
    private static String url;
    private static String userName;
    private static String password;

    private Connection connection;

    static {
        dbType = DbConfig.DB_TYPE;
        url = DbConfig.DB_URL;
        userName = DbConfig.USER_NAME;
        password = DbConfig.PASSWORD;
    }

    public Connection getConnection() throws Exception {
        this.connection = DriverManager.getConnection(url, userName, password);
        return connection;
    }
}
