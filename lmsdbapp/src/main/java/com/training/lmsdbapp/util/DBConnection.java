package com.training.lmsdbapp.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static Properties properties = new Properties();

    static {
        try (InputStream input = DBConnection.class
                .getClassLoader()
                .getResourceAsStream("db.properties")) {

            if (input == null) {
                throw new RuntimeException("db.properties not found");
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Unable to load db.properties", e);
        }
    }

    public static String getDriver() {
        return properties.getProperty("jdbc.driver");
    }

    public static String getUrl() {
        return properties.getProperty("jdbc.url");
    }

    public static String getUsername() {
        return properties.getProperty("jdbc.username");
    }

    public static String getPassword() {
        return properties.getProperty("jdbc.password");
    }

    public static Connection getConnection()
            throws ClassNotFoundException, SQLException {

        Class.forName(getDriver());

        return DriverManager.getConnection(
                getUrl(),
                getUsername(),
                getPassword()
        );
    }
}