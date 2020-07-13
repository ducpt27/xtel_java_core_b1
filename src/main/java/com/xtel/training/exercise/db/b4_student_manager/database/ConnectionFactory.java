package com.xtel.training.exercise.db.b4_student_manager.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static DBConnectorConfig dbConfig = DBConnectorConfig.getDBConnectorConfig();

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(dbConfig.DRIVER);
        Connection conn = DriverManager.getConnection(dbConfig.URL, dbConfig.USER, dbConfig.PASSWORD);
        return conn;
    }
}