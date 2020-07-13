package com.xtel.training.exercise.db.b4_student_manager.database;

import com.xtel.training.common.utils.XMLUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "db")
@XmlAccessorType(XmlAccessType.FIELD)
public class DBConnectorConfig {

    private static final String SRC_PATH = System.getProperty("user.dir");

    private static String FILE_PATH = SRC_PATH + "\\config\\db.xml";

    @XmlElement(name = "driver")
    public String DRIVER;

    @XmlElement(name = "url")
    public String URL;

    @XmlElement(name = "user")
    public String USER;

    @XmlElement(name = "password")
    public String PASSWORD;

    public DBConnectorConfig() {
    }

    public static DBConnectorConfig getDBConnectorConfig() {
        try {
            return (DBConnectorConfig) XMLUtils.toObject(new DBConnectorConfig(), FILE_PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}